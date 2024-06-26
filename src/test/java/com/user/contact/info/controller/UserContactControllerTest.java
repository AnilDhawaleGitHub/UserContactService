package com.user.contact.info.controller;

import com.user.contact.info.dto.UserContactDto;
import com.user.contact.info.entity.UserContact;
import com.user.contact.info.service.UserContactInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.user.contact.info.util.UserContactInfoUtil.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith({MockitoExtension.class})
public class UserContactControllerTest {


  @InjectMocks
  private UserContactInfoController controller;

  @Mock
  private UserContactInfoService userContactInfoService;

  List<UserContact> listOfUserContact = null;
  UserContact userContact = null;
  UserContactDto userContactDto = null;
  UserContact updatedUserContact = null;

  @BeforeEach
  public void setup() {
    listOfUserContact = buildUserContactInfo();
    userContact = buildUserContactInfoForFindById();
    userContactDto = buildUserInfoDto();
    updatedUserContact = buildReceivedUserContactInfoForFindById();
  }

  //get all user contact info test case
  @Test
  public void shouldReturnAllUserContactInfoTest() {
    when(userContactInfoService.getAllUserContactInfo())
        .thenReturn(listOfUserContact);
    ResponseEntity responseEntity = controller.getAllUserContactInfo();
    assertNotNull(responseEntity);
    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
    ArrayList arrayList = (ArrayList) responseEntity.getBody();
    assertThat(((ArrayList) responseEntity.getBody()).size()).isEqualTo(2);

  }


  //get user contact info by id test case
  @Test
  public void shouldReturnUserContactInfoByIdTest() {
    when(userContactInfoService.getUserContactInfoById(1L))
        .thenReturn(userContact);
    UserContact userContact = controller.getUserContactInfoById(1L);
    Assert.assertNotNull(userContact);
    assertThat(userContact.getFirstName()).isEqualTo("FirstName");
    assertThat(userContact.getContactNo()).isEqualTo("1234567890");
    assertThat(userContact.getAddress().getPostCode()).isEqualTo("XXZ123");

  }


  //get user contact info by ids (1,2,3 etc) test case
  @Test
  public void shouldReturnUserDetailsByIdsTest() {
    when(userContactInfoService.getUserContactInfoByIds("1,2"))
        .thenReturn(this.listOfUserContact);
    List<UserContact> listOfUserContact = controller.getUserContactInfoByIds("1,2");
    Assert.assertNotNull(listOfUserContact);
    assertThat(listOfUserContact.size()).isEqualTo(2);

  }

  //delete user contact info by ids test case
  @Test
  public void shouldDeleteUserContactInfoByIdTest() {
    when(userContactInfoService.deleteUserContactInfoById(1L))
        .thenReturn("user contact info has been deleted for Id : 1");
   ResponseEntity responseEntity = controller.deleteUserContactInfoById(1L);
    Assert.assertNotNull(responseEntity);
    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
  }


  //save user contact info test case
  @Test
  public void shouldSaveUserContactInfoTest() {
    when(userContactInfoService.saveUserContactInfo(userContactDto))
        .thenReturn(userContact);
    ResponseEntity responseEntity = controller.saveUserContractInfo(userContactDto);
    Assert.assertNotNull(userContact);
    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();

  }

  //update user contact info by id test case
  @Test
  public void shouldUpdateUserContactInfoByIdTest() {
    when(userContactInfoService.updateUserContactInfoById(1L, userContactDto))
        .thenReturn(updatedUserContact);
    ResponseEntity responseEntity = controller.updateUserContactInfoById(userContactDto, 1L);
    Assert.assertNotNull(responseEntity);
    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
    UserContact userContact = (UserContact) responseEntity.getBody();
    assertThat(userContact.getFirstName()).isEqualTo("UpdatedFirstName");
  }


}
