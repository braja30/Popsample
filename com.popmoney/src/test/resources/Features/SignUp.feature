@SignUp
Feature: This feature is to test the popmoney.com application
  Scenario: This test is to SignUp the popmoney.com application
    Given The user landed in home page and enter email or phone number, click get started
    When Select "Ally Bank" and submit
    And Enter First name ,last name and click Next
    And Enter all required information for profile creation,select state as "CA" from dropdown by using "value" and click SignUp
    Then The user should see the welcome message as per signUp firstname
   


#Feature: This is to test popmoney.com application
#Scenario: SignUp scenario of popmoney.com
#Given: User navigate to Popmoney.com website
#When: User enter mobile number or Email
#And: Click Get Started and user enter into bank selection page
#Then: Select "Ally bank" in bank selection
#And: Click submit and user enter into pre-login page
#Then: User Enter Firstname and lastname
#Then: User click reCaptcha, Next button and user enter into profile creation page
#Then: Enter valid mobile no which got OTP for further process
#Then: Enter valid password, rePassword as per password policys
#Then: Click appropriate check box, If you need bussiness profile.
#Then: Enter current address details
##Then: Select state as "CA" from dropdown by using "value" and click SignUp
#Then: Enter Zip code and date of birth
#Then: Click check box for Terms & condition acceptance.
#Then: Click submit button
#And: User Got success message for signup in his/her firstname.    