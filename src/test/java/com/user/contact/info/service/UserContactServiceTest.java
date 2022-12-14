package com.user.contact.info.service;

import static com.user.contact.info.util.UserContactInfoUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.user.contact.info.dto.UserContactDto;
import com.user.contact.info.entity.UserContact;

import com.user.contact.info.repository.UserContactInfoRepository;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class UserContactServiceTest {

  @InjectMocks
  UserContactInfoService userContactInfoService = new UserContactInfoServiceImpl();

  @Mock
  UserContactInfoRepository userContactInfoRepository;

  List<UserContact> listOfUserContact = null;
  UserContact userContact = null;
  UserContactDto userContactDto = null;
  UserContact updatedUserContact = null;
  UserContactDto userContactDtoForSave = null;


  @BeforeEach
  public void setup() {
    listOfUserContact = buildUserContactInfo();
    userContact = buildUserContactInfoForFindById();
    userContactDto = buildUserInfoDto();
    updatedUserContact = buildReceivedUserContactInfoForFindById();
    userContactDtoForSave = buildUserInfoDtoForSave();

  }

  //get all user contact info test case
  @Test
  public void shouldReturnAllUserContactInfoTest() {
    when(userContactInfoRepository.findAll()).thenReturn(this.listOfUserContact);
    List<UserContact> listOfUserContact = userContactInfoService.getAllUserContactInfo();
    assertNotNull(listOfUserContact);
    assertThat(listOfUserContact.size()).isEqualTo(2);
  }


  //get user contact info by id test case
  @Test
  public void shouldReturnUserContactInfoByIdTest() {
    when(userContactInfoRepository.findById(1L))
        .thenReturn(java.util.Optional.ofNullable(userContact));
    UserContact userContact = userContactInfoService.getUserContactInfoById(1L);
    assertNotNull(userContact);
    assertThat(userContact.getFirstName()).isEqualTo("FirstName");
    assertThat(userContact.getContactNo()).isEqualTo("1234567890");
    assertThat(userContact.getAddress().getPostCode()).isEqualTo("XXZ123");

  }


  //get user contact info by ids (1,2,3 etc) test case
  @Test
  public void shouldReturnUserDetailsByIdsTest() {
    when(userContactInfoRepository.findAllById(Arrays.asList(1L, 2L)))
        .thenReturn(this.listOfUserContact);
    List<UserContact> listOfUserContact = userContactInfoService.getUserContactInfoByIds("1,2");
    assertNotNull(listOfUserContact);
    assertThat(listOfUserContact.size()).isEqualTo(2);
  }


  //delete user contact info by ids test case
  @Test
  public void shouldDeleteUserContactInfoByIdTest() {
    when(userContactInfoRepository.findById(1L))
        .thenReturn(java.util.Optional.ofNullable(userContact));

    doNothing().when(userContactInfoRepository).deleteById(1L);
    String deleteMsg= userContactInfoService.deleteUserContactInfoById(1L);
    assertNotNull(deleteMsg);
  }


  //save user contact info test case
  @Test
  public void shouldSaveUserContactInfoTest() {
    when(userContactInfoRepository.save(this.userContact)).thenReturn(this.userContact);
    UserContact userContact = userContactInfoService
        .saveUserContactInfo(userContactDtoForSave);
    assertNotNull(userContact);
  }


  //update user contact info by id test case
  @Test
  public void shouldUpdateUserContactInfoByIdTest() {
    when(userContactInfoRepository.findById(1L))
        .thenReturn(java.util.Optional.ofNullable(this.userContact));
    when(userContactInfoRepository.save(this.userContact)).thenReturn(
        this.userContact);
    UserContact userContact = userContactInfoService
        .updateUserContactInfoById(1L, userContactDto);
    Assert.assertNotNull(userContact);
    assertThat(userContact.getFirstName()).isEqualTo("UpdatedFirstName");
  }


}

