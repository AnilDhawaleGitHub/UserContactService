package com.user.contact.info.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "userContactInfoWith")
@Table(name = "User_Details", uniqueConstraints = @UniqueConstraint(columnNames = "contact_no"))
public class UserContact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name")
  @NotEmpty(message = "first name should Not be empty")
  private String firstName;

  @Column(name = "last_name")
  @NotEmpty(message = "last name should Not be empty")
  private String lastName;

  @Column(name = "contact_no")

  @Pattern(regexp = "^\\d{10}$", message = "invalid contact number, please enter 10 digit no only")
  private String contactNo;

  @Column(name = "alt_contact_no")
  @Pattern(regexp = "^$|^[0-9X]{10}$", message = "invalid alternate contact number, please enter 10 digit no only")
  private String altContactNo;

  @OneToOne(
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL
  )
  @JoinColumn(name = "address_id")
  private Address address;

}
