package com.user.contact.info.util;

import com.user.contact.info.dto.AddressDto;
import com.user.contact.info.dto.UserContactDto;
import com.user.contact.info.entity.UserContact;
import java.util.ArrayList;
import java.util.List;

public class UserContactInfoUtil {

  public static final String USER_CONTACT_INFO_NOT_FOUND_IN_DB = "user contact info not found in the database for Id : ";
  public static final String REQUESTED_USER_CONTACT_INFO_NOT_FOUND_IN_DB = "user contact info for the requested id's not present in database : ";
  public static final String NO_USER_CONTACT_INFO_FOUND_IN_DB = "no user contact info found in the database ";
  private static final String USER_CONTACT_INFO_DELETED = "user contact info has been deleted for Id : ";
  public static final String VALID_ID_ENTER = "please enter valid id's with comma separated eg: 1,2,3 ";

  public static List<UserContact> buildUserContactInfo() {

    List<UserContact> listOffUser = new ArrayList<>();

    com.user.contact.info.entity.Address address1 = com.user.contact.info.entity.Address.addressWith().id(1L).doorNo("30A").streetName("Street Name")
        .postCode("XXZ123").build();
    UserContact userContact1 = UserContact.userContactInfoWith().id(1L)
        .firstName("FirstName")
        .lastName("LastName").contactNo("1234567890").address(address1).build();

    com.user.contact.info.entity.Address address2 = com.user.contact.info.entity.Address.addressWith().id(2L).doorNo("30B").streetName("Street Name1")
        .postCode("XXZ121").build();
    UserContact userContact2 = UserContact.userContactInfoWith().id(1L)
        .firstName("FirstName1")
        .lastName("LastName1").contactNo("1234567891").address(address2).build();

    listOffUser.add(userContact1);
    listOffUser.add(userContact2);

    return listOffUser;

  }

  public static UserContact buildUserContactInfoForFindById() {

    com.user.contact.info.entity.Address address = com.user.contact.info.entity.Address.addressWith().id(0L).doorNo("30A").streetName("Street Name")
        .postCode("XXZ123").build();

    UserContact userContact = UserContact.userContactInfoWith().id(0L)
        .firstName("FirstName").
            lastName("LastName").contactNo("1234567890").address(address).build();
    return userContact;
  }

  public static UserContactDto buildUserInfoDtoForSave() {

    AddressDto addressDtoRequest = AddressDto.addressDtoBuilderWith().doorNo("30A")
        .streetName("Street Name").postCode("XXZ123").build();
    UserContactDto userContactDto = UserContactDto.userContactInfoDtoWith().
        firstName("FirstName").lastName("LastName").contactNo("1234567890").address(
        addressDtoRequest)
        .build();
    return userContactDto;
  }

  public static UserContactDto buildUserInfoDto() {

    AddressDto addressDtoRequest = AddressDto.addressDtoBuilderWith().doorNo("U30A")
        .streetName("Updated Street Name").postCode("UXXZ123").build();
    UserContactDto userContactDto = UserContactDto.userContactInfoDtoWith().
        firstName("UpdatedFirstName").lastName("UpdatedLastName").contactNo("1234567890")
        .address(addressDtoRequest).build();
    return userContactDto;
  }

  public static UserContact buildReceivedUserContactInfoForFindById() {

    com.user.contact.info.entity.Address address = com.user.contact.info.entity.Address.addressWith().id(1L).doorNo("30A").streetName("Street Name")
        .postCode("XXZ123").build();
    UserContact userContact = UserContact.userContactInfoWith().id(1L)
        .firstName("UpdatedFirstName").
            lastName("UpdatedLastName").contactNo("1234567890").address(address).build();
    return userContact;
  }

}
