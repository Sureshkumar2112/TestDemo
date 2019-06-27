package com.Stepdef;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Amazon.CodeAmazon;
import com.Amazon.ExcelRead;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends ExcelRead{
	CodeAmazon code = new CodeAmazon();
	
	
	@Given("^I enter Home page Url$")
	public void i_enter_Home_page_Url()
	{
		code.url();    
	}

	@When("^I Navigate to Sign in button$")
	public void i_Navigate_to_Sign_in_button() throws Exception
	{
		code.signIn();
	}
	
	@And("^I enter (.*?) and (.*?)$")
	public void i_enter_User_name_and_Password(String arg1, String arg2)
	{
	    code.credentials(arg1, arg2);  
	} 
	
	@And("^I able to click Login button$")
	public void i_able_to_click_Login_button() throws Throwable {
		
		code.clkLogin();
	    
	}

	@Then("^I successfully signed into my account$")
	public void i_successfully_signed_into_my_account() throws Exception 
	{
		code.success();
	}
	
	@Then("^I should Signed out$")
	public void i_should_Signed_out() 
	{
		code.signOut();	
	}
	
	@Given("^I sign in to the webpage$")  //sce2
	public void i_sign_in_to_the_webpage() throws Exception
	{
		code.url();
		code.signIn();
		code.credentialProp();
		code.clkLogin();
	}

	@When("^I Enter the particular product$")
	public void i_Enter_the_particular_product() throws Exception
	{
		code.enterProduct();
	}

	@When("^I click search$")
	public void i_click_search() 
	{
	    code.clkSearch();
	}

	@When("^I should select one product$")
	public void i_should_select_one_product()
	{
	    code.clkProduct();
	}

	@Then("^I click Add to cart option$")
	public void i_click_Add_to_cart_option()
	{
	    code.addCart();
	}

	@Then("^I click a cart tab$")
	public void i_click_a_cart_tab() throws Exception
	{
	   code.cartTab();
	}

	@Then("^I able to see product added$")
	public void i_able_to_see_product_added() throws Exception
	{
	   code.compareProd();
	}

	@When("^I should delete one product$")
	public void i_should_delete_one_product() throws Exception
	{
	    code.Delete();
	}

	@When("^I should see the product was removed$")
	public void i_should_see_the_product_was_removed() throws Exception
	{
	    code.removeProduct();
	}

	@When("^I click amazon pay tab$")
	public void i_click_amazon_pay_tab()
	{
	    code.clkAmazonPay();
	}

	@When("^I click view statement option$")
	public void i_click_view_statement_option()
	{
		code.clkViewStmt();
	}

	@When("^I able to see all statement details$")
	public void i_able_to_see_all_statement_details() throws Exception
	{
	    code.stmtDetails();
	}

	//sce5
	@When("^I navigate to add new address page$")
	public void i_navigate_to_add_new_address_page() 
	{
	    code.newAddress();
	}

	@Then("^I pass values in all mandatory fields$")
	public void i_pass_values_in_all_mandatory_fields() throws IOException, InterruptedException 
	{
	    code.addValue();
	}

	@When("^I click add address button$")
	public void i_click_add_address_button() 
	{
	    code.clkAddress();
	}

	@Then("^I see added address and click delete$")
	public void i_see_added_address_and_click_delete() 
	{
	    code.clkDel();
	}

	@Then("^I able to see address deleted$")
	public void i_able_to_see_address_deleted()
	{
	    code.assDelete();
	}

	
	
	
	
	
	
	
}
