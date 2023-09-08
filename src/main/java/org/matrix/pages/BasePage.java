package org.matrix.pages;

import org.openqa.selenium.support.PageFactory;

/**
 * The Class BasePage every Page should extend this class.
 *
 * @AbedZoabi
 */
public class BasePage extends AbstractPage{

	public BasePage() {
		super();
		PageFactory.initElements(driver, this);
	}

}
