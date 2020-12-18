package com.grainchain.exceptions;

public class PageNotLoaded extends Exception {

    public PageNotLoaded() {
        System.err.println("Page was not loaded in time");
    }
}
