package com.pinterest.api;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.SearchPage;

public class SearchTest {
    @Test
    public void testSearch() {
        String search = "лето";
        SearchPage searchPage = new SearchPage();
        String body = searchPage.doSearch(search);
        Assertions.assertTrue(body.contains(search),"по запросу" + search + "не найден" );
    }
}
