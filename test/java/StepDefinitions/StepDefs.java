package StepDefinitions;

import StepDefinitions.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.BaseFunc;
import pages.HomePage;

public class StepDefs {
    HomePage homePage;
    SearchResultPage resultPage;
    BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "rus.delfi.lv";

    @Given("Delfi home page")
    public void open_home_page() {
        baseFunc.openPage(HOME_PAGE);
        homePage = new HomePage(baseFunc);
    }

    @When("we are searching for (.*)")
    public void search(String toSearch) {
        homePage.search(toSearch);
        resultPage = new SearchResultPage(baseFunc);
    }

    @Then("search results count is ([0-9]*)")
    public void check_results(Integer count) {
        Assert.assertEquals("Result Count doesn't match", count, resultPage.getResultCount());
    }
}