package org.matrix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DashboardPage extends AbstractPage {

    @FindBy(tagName = "table")
    private WebElement transactionTable;





    //Method to check the transaction table
    public DashboardPage() {
        PageFactory.initElements(driver, this);
        waitForWebElement(transactionTable, WAIT);
    }

    // Check if the table displayed
    public boolean checkIfTableDisplayed(){

        if(transactionTable.isDisplayed()){
            return true;
        }
        return  false;
    }


    //Method to get the rows of the table
    public int getCountOfStatusComplete() {

        // Find all rows in the table
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        int completeCount = 0;
        for (WebElement row : rows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Check if the row has at least one cell (assuming Status is the first column)
            if (!cells.isEmpty()) {
                // Get the text from the Status cell (assuming Status is the first column)
                String status = cells.get(0).getText();

                // Check if the status is "Complete"
                if (status.equals("Complete")) {
                    completeCount++;
                }
            }

        }
        return completeCount;
    }


}
