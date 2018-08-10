package com.example.indicatorlibrary;

class PagesLessExeption extends Exception {
        @Override
    public String getMessage() {
            return "Pages must equal or largerthan 2";
        }
}
