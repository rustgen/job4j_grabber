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
    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer?page=", SOURCE_LINK);
    private static final int PAGE_NUM = 5;
    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private static String retrieveDescription(String link) {
        Document document;
        try {
            document = Jsoup.connect(link).get();
            Elements description = document.select(".style-ugc");
            return description.text();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(String.format(
                    "There is no connection with such link --- \"%s\"", link
            ));
        }
    }

    private Post parsePost(Element row) {
        Element titleElement = row.select(".vacancy-card__title").first();
        Element date = row.select(".vacancy-card__date").first();
        Element linkElement = titleElement.child(0);
        String vacancyName = titleElement.text();
        String dateVacancy = date.child(0).attr("datetime");
        String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        String describe;
        try {
            describe = retrieveDescription(link);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("There is no such Element");
        }
        return new Post(vacancyName, link, describe, dateTimeParser.parse(dateVacancy));
    }

    @Override
    public List<Post> list(String linkIn) {
        List<Post> list = new ArrayList<>();
        for (int i = 1; i <= PAGE_NUM; i++) {
            Connection connection = Jsoup.connect(linkIn + i);
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
