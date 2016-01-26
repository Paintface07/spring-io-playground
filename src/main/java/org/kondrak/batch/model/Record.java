package org.kondrak.batch.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 1/22/2016.
 */
@Data
@Repository
public class Record {
    private Long jobNumber;
    private Integer docNumber;
    private String borough;
    private String houseNumber;
    private String streetName;
    private Long block;
    private Long lot;
    private Long bin;
    private String jobType;
    private String jobStatus;
    private String jobStatusDescription;
    private String latestActionDt;
    private String buildingType;
    private Long communityBoard;
    private String cluster;
    private String landmarked;
    private String adultEstablishment;
    private String loftBoard;
    private String cityOwned;
    private String littleE;
    private String pcFiled;
    private String eFilingFiled;
    private String plumbing;
    private String mechanical;
    private String boiler;
    private String fuelBurning;
    private String fuelStorage;
    private String standpipe;
    private String sprinkler;
    private String fireAlarm;
    private String equipment;
    private String fireSuppression;
    private String curbCut;
    private String other;
    private String otherDescription;
    private String applicantFirstName;
    private String applicantLastName;
    private String applicantProfessionalTitle;
    private Long applicantLicenseNumber;
    private String professionalCert;
    private String preFilingDt;
    private String paidDt;
    private String fullyPaidDt;
    private String assignedDt;
    private String approvedDt;
    private String fullyPermittedDt;
    private String initialCost;
    private String totalEstimatedFee;
    private String feeStatus;
    private Long existingSquareFootage;
    private Long proposedSquareFootage;
    private String horizontalEnlargement;
    private String verticalEnlargement;
    private Long enlargementSquareFootage;
    private Long streetFrontage;
    private Long existingStories;
    private Long proposedStories;
    private Long existingHeight;
    private Long proposedHeight;
    private Long existingUnits;
    private Long proposedUnits;
    private String existingOccupancy;
    private String proposedOccupancy;
    private String siteFill;
    private String zoningDistrictOne;
    private String zoningDistrictTwo;
    private String zoningDistrictThree;
    private String specialDistrictOne;
    private String specialDistrictTwo;
    private String ownerType;
    private String nonProfit;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerBusinessName;
    private String ownerHouseNumber;
    private String ownerHouseStreetName;
    private String city;
    private String resSt;
    private String zip;
    private Long ownerPhone;
    private String jobDescription;
    private String dobRunDt;
}
