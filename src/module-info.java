module copy3 {
        requires javafx.fxml;
        requires javafx.controls;
        requires javafx.graphics;
        requires java.logging;
        requires java.sql;
        opens ui;
        opens domain;
        opens service;
        opens repository;
        opens streams;
        }