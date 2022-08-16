package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {
    private static final String SOURCE_LINK = "https://career.habr.com";
    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);
    private final DateTimeParser dateTimeParser;
    private static final int PAGE_NUM = 5;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private static String retrieveDescription(String link) throws IOException {
        Document document = Jsoup.connect(link).get();
        Elements description = document.select(".style-ugc");
        return description.text();
    }

    private Post parsePost(Element row) {
        Element titleElement = row.select(".vacancy-card__title").first();
        Element date = row.select(".vacancy-card__date").first();
        Element linkElement = titleElement.child(0);
        String vacancyName = titleElement.text();
        String dateVacancy = date.child(0).attr("datetime");
        String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        String describe = null;
        try {
            describe = retrieveDescription(link);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Post(vacancyName, link, describe, dateTimeParser.parse(dateVacancy));
    }

    @Override
    public List<Post> list(String linkIn) {
        List<Post> list = new ArrayList<>();
        for (int i = 1; i <= PAGE_NUM; i++) {
            final String PAGE_NUM_LINK = String.format("%s?page=%d", linkIn, i);
            Connection connection = Jsoup.connect(PAGE_NUM_LINK);
            Document document;
            try {
                document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> {
                    list.add(parsePost(row));
                });
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalArgumentException(String.format(
                        "There is no connection with such link --- \"%s\"", linkIn
                ));
            }
        }
        return list;
    }

    public static void main(String[] args) {

        HabrCareerParse parse = new HabrCareerParse(new HabrCareerDateTimeParser());
        List<Post> posts = parse.list(PAGE_LINK);
        posts.forEach(System.out::println);
    }
}
