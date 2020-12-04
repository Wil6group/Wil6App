package com.example.app_proto_02;

public class Score {
    private String section;
    private  String game;
    private int userScore;
    private int totalScore;

    public Score(String section, String game, int userScore, int totalScore) {
        this.section = section;
        this.game = game;
        this.userScore = userScore;
        this.totalScore = totalScore;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
