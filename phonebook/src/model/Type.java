package model;

public class Type {
 private int id;
 private String companyname;
 private String address;

 public Type() {
 }

 public Type(int id, String companyname, String address) {
  this.id = id;
  this.companyname = companyname;
  this.address = address;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getCompanyname() {
  return companyname;
 }

 public void setCompanyname(String companyname) {
  this.companyname = companyname;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 @Override
 public String toString() {
  return "Type{" +
          "id=" + id +
          ", companyname='" + companyname + '\'' +
          ", address='" + address + '\'' +
          '}';
 }
}
