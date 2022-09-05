package ru.job4j.ood.ocp;

public class Client extends Server {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }
}
