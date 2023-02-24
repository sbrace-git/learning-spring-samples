package org.example;

import java.util.List;

public class HelloBox {
    private Hello refHello;
    private Hello nullHello;
    private Hello hello;
    private List<Hello> helloList;
    private List<String> nameList;

    public HelloBox() {
        System.out.println("create HelloBox");
    }

    @Override
    public String toString() {
        return "HelloBox{" +
                "\n refHello=" + refHello +
                ",\n nullHello=" + nullHello +
                ",\n hello=" + hello +
                ",\n helloList=" + helloList +
                ",\n nameList=" + nameList +
                '}';
    }

    public Hello getRefHello() {
        return refHello;
    }

    public void setRefHello(Hello refHello) {
        this.refHello = refHello;
    }

    public Hello getNullHello() {
        return nullHello;
    }

    public void setNullHello(Hello nullHello) {
        this.nullHello = nullHello;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public List<Hello> getHelloList() {
        return helloList;
    }

    public void setHelloList(List<Hello> helloList) {
        this.helloList = helloList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
