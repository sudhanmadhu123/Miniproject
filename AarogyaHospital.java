// //The management system should have the following features: - 
// Add a patient’s details to the system whenever there is a new patient admitted. 
// The patient details should include his/her name, age, gender, Aadhar Card number, contact number, city, address, date of admission, guardian's name, guardian’s address, guardian’s contact number. Assign a unique id to each patient admitted. 
// Note: Validate user entered data. Such as 
// Number of digits in age is 1 or 2 digits. 
// Aadhar card number should contains 12 digits. 
// Contact number should contain 10 digits only. 

// The system can show the list of patients at any point of time. Basically, the system should be dynamic and a real time system. In other words, it can provide results at any point of time without any delays. Display proper error message if patients list is empty. 

// Given the unique id assigned to a patient, provide all the details of that patient. 
// In other words, the system should provide details about a patient using his/her unique id or name. 

// The system can provide the list of all the patients from a particular city or a state. Also provide the list of patients belonging to a particular age group. For example, you can be asked to give the list of patients in the age group 50-60. Handle NullPointerException if user entered values are empty.  

// Mark the patient recovered when he starts working fine. 

// The system should be able to delete the information of a patient when asked to.  Handle NullPointerException if user entered patient id is not present in list. 

// Implement these features using efficient data structures, collections  and OOP concepts learnt in the Java Foundation course. Write clean and organized codes using proper objects and methods. 

import java.util.*;

class AarogyaMember {
  String patientName, gender, city, address;
  int age;
  long aadharNum, phoneNum;
  String guardianName, gAddress;
  long gContact;
  int pId;
  String recovery;

  AarogyaMember(String patientName, String gender, String city, String address, int age, long aadharNum, long phoneNum,
      String guardianName, String gAddress, long gContact, int pId, String recovery) {
    this.patientName = patientName;
    this.gender = gender;
    this.city = city;
    this.address = address;
    this.age = age;
    this.aadharNum = aadharNum;
    this.phoneNum = phoneNum;
    this.guardianName = guardianName;
    this.gAddress = gAddress;
    this.gContact = gContact;
    this.pId = pId;
    this.recovery = recovery;
  }

  public String getRecoveryStatus() {
    return recovery;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public long getAadharNum() {
    return aadharNum;
  }

  public void setAadharNum(long aadharNum) {
    this.aadharNum = aadharNum;
  }

  public long getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(long phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getGuardianName() {
    return guardianName;
  }

  public void setGuardianName(String guardianName) {
    this.guardianName = guardianName;
  }

  public String getgAddress() {
    return gAddress;
  }

  public void setgAddress(String gAddress) {
    this.gAddress = gAddress;
  }

  public long getgContact() {
    return gContact;
  }

  public void setgContact(long gContact) {
    this.gContact = gContact;
  }

  public int getPId() {
    return pId;
  }
}

class NullPointerException extends Exception {
  NullPointerException(String str) {
    super(str);
  }
}

public class AarogyaHospital {
  Scanner s = new Scanner(System.in);
  ArrayList<AarogyaMember> patients = new ArrayList<AarogyaMember>();
  int choice;

  public int options() {
    System.out.println("Press 1 for adding new member");
    System.out.println("Press 2 to view list of all available members");
    System.out.println("Press 3 to search member by ID");
    System.out.println("Press 4 to search member from a particular city");
    System.out.println("Press 5 to search member from a particular age group");
    System.out.println("Press 6 to mark recovery of a member");
    System.out.println("Press 7 to delete data of a member");
    System.out.println("Press 0 to exit");
    System.out.println("Enter choice");
    choice = s.nextInt();
    return choice;
  }

  public void addPatient() {
    Random rand = new Random();
    System.out.println("Enter the patient name:");
    String patientName = s.next();
    System.out.println("Enter the gender ");
    String gender = s.next();
    // while (true) {
    System.out.println("Enter age");
    int age = s.nextInt();
    if (Integer.toString(age).length() != 2) {
      System.out.println("Number of digits in age is 1 or 2 digits.");
    }
    // count++;
    // } else {
    // break;
    // }
    // }

    System.out.println("Enter address");
    String address = s.next();
    System.out.println("enter City");
    String city = s.next();
    System.out.println("Enter Aadhaar number");
    long aadharNum = s.nextLong();
    if (Long.toString(aadharNum).length() != 12) {
      System.out.println("Aadhar card number should contains 12 digits. ");
    }
    System.out.println("Enter the phone number");
    long phoneNum = s.nextLong();
    if (Long.toString(phoneNum).length() != 10) {
      System.out.println("Contact number should contain 10 digits only.  ");
    }
    System.out.println("Enter guardian name");
    String guardianName = s.next();
    System.out.println("Enter Guardian address ");
    String gAddress = s.next();
    System.out.println("Enter guardian Phone number");
    long gContact = s.nextLong();
    if (Long.toString(gContact).length() != 10) {
      System.out.println("Contact number should contain 10 digits only.  ");
    }
    System.out.println("Enter recovery status");
    String recovery = s.next();
    if (Integer.toString(age).length() == 2 && Long.toString(aadharNum).length() == 12
        && Long.toString(phoneNum).length() == 10) {
      patients.add(new AarogyaMember(patientName, gender, city, address, age, aadharNum, phoneNum, guardianName,
          gAddress, gContact, Math.abs(rand.nextInt()), recovery));
      System.out.println("Patient added successfully!!");
    } else {
      System.out.println("Please Enter correct details");
    }
  }

  public void viewPatientsList() {
    if (patients.size() == 0) {
      System.out.println("Currently there is no patients here");
      System.out.println("***********");
    }
    System.out.println("Patients details");
    int i = 1;
    for (AarogyaMember p : patients) {
      System.out.println("Ptient " + i + " Details :");
      System.out.println("Name            --->  " + p.getPatientName());
      System.out.println("Gender          --->  " + p.getGender());
      System.out.println("Age             --->  " + p.getAge());
      System.out.println("Patient Id      --->  " + p.getPId());
      System.out.println("***********");
      System.out.println();
      i++;
    }
  }

  public void searchById() throws NullPointerException {
    if (patients.size() == 0) {
      throw new NullPointerException("Currently there is no patients here");
    } else {
      System.out.println("Enter patients ID to get information of the patient");
      int id = s.nextInt();
      for (AarogyaMember p : patients) {
        if (p.getPId() == id) {
          System.out.println("Yes !,, Patient is here details are shown below");
          System.out.println("Name            --->  " + p.getPatientName());
          System.out.println("Gender          --->  " + p.getGender());
          System.out.println("Age             ---> " + p.getAge());
          System.out.println("Address         ---> " + p.getAddress());
          System.out.println("City            ---> " + p.getCity());
          System.out.println("Aadhaar Number  ---> " + p.getAadharNum());
          System.out.println("Phone Number    ---> " + p.getPhoneNum());
          System.out.println("Guardian Name   ---> " + p.getGuardianName());
          System.out.println("Guardian Address---> " + p.getgAddress());
          System.out.println("Guardian Contact Number  --->  " + p.getgContact());
          System.out.println("Recovery status    ---->    " + p.getRecoveryStatus());
          System.out.println("***********");
          System.out.println();
        } else {
          System.out.println(" There is no patient for that id please enter correct Id");
        }
      }
    }

  }

  public void searchByCity() {
    if (patients.size() == 0) {
      System.out.println("Currently there is no patients here");
      System.out.println("***********");
    }
    System.out.println("Enter patients city name to get information of the patient");
    String cityName = s.next();
    for (AarogyaMember p : patients) {
      if (p.getCity().equals(cityName)) {
        System.out.println("Yes !,, Patient is here details are shown below");
        System.out.println("Name            --->  " + p.getPatientName());
        System.out.println("Gender          --->  " + p.getGender());
        System.out.println("Age             ---> " + p.getAge());
        System.out.println("***********");
        System.out.println();
      } else {
        System.out.println(" There is no patient from that city  please enter correct city name");
      }
    }
  }

  public void searchByAge() {
    if (patients.size() == 0) {
      System.out.println("Currently there is no patients here");
      System.out.println("***********");
    }
    System.out.println("Enter patients age to get information of the patient");
    int pAge = s.nextInt();
    int count = 0;
    for (AarogyaMember pa : patients) {
      if (pa.getAge() == pAge) {
        count = count + 1;
      }
    }
    System.out.println("There are " + count + " patients from this age group");
    for (AarogyaMember p : patients) {
      if (p.getAge() == pAge) {
        System.out.println("Name            --->  " + p.getPatientName());
        System.out.println("Gender          --->  " + p.getGender());
        System.out.println("Age             ---> " + p.getAge());
        System.out.println("***********");
        System.out.println();
      } else {
        System.out.println(" There is no patient of that age  please enter correct age");
      }
    }
  }

  public void deletePatient() throws NullPointerException {
    if (patients.size() == 0) {
      throw new NullPointerException("Currently there is no patients here");
    } else {
      System.out.println("Enter patient name to delete");
      String name = s.next();
      for (AarogyaMember p : patients) {
        if (p.getPatientName().equals(name)) {
          patients.remove(p);
          break;
        }
      }
      System.out.println("Remaining patients are :");
      for (AarogyaMember p : patients) {
        System.out.println(p.getPatientName());
      }
    }
  }

  public void recoveryStatus() {
    if (patients.size() == 0) {
      System.out.println("Currently there is no patients here");
      System.out.println("***********");
    }
    System.out.println("to update recoverystatus ");

    System.out.println("Enter name of the patient");
    String name = s.next();
    System.out.println("If patient is recoverd enter recovered ");
    for (AarogyaMember p : patients) {
      if (p.getPatientName().equals(name)) {
        p.recovery = s.next();
        break;
      }
    }

    for (AarogyaMember p : patients) {
      if (p.getRecoveryStatus().equals("recovered")) {
        System.out.println(p.patientName + " ");
        System.out.println("Recovery status is " + p.recovery);
      }
    }

  }

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    AarogyaHospital obj = new AarogyaHospital();
    int option;
    do {
      // System.out.println("Enter choice");
      option = obj.options();
      switch (option) {
        case 1: {
          obj.addPatient();
          break;
        }
        case 2: {
          obj.viewPatientsList();
          break;
        }
        case 3: {
          try {
            obj.searchById();
            break;
          } catch (NullPointerException e) {
            System.out.println(e);
            break;
          }

        }
        case 4: {
          obj.searchByCity();
          break;
        }
        case 5: {
          obj.searchByAge();
          break;
        }
        case 6: {
          obj.recoveryStatus();
          break;
        }
        case 7: {
          try {
            obj.deletePatient();
            break;
          } catch (NullPointerException e) {
            System.out.println(e);
            break;
          }
        }
        case 0: {
          System.out.println("Thank You");
          break;
        }
      }
    } while (option != 0);
  }
}