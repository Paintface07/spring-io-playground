package org.kondrak.batch;

import org.kondrak.batch.model.Record;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * REFERENCES: https://spring.io/guides/gs/batch-processing/
 *             http://www.javacodegeeks.com/2015/03/spring-batch-tutorial.html
 *             https://www.quora.com/Where-can-I-find-large-datasets-open-to-the-public
 *             https://data.cityofnewyork.us/Housing-Development/DOB-Job-Application-Filings/ic3t-wcy2
 *             http://snap.stanford.edu/data/index.html
 * Created by Administrator on 1/22/2016.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean public ItemReader<Record> reader() {
        FlatFileItemReader<Record> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("DOB_Job_Application_Filings.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Record>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setDelimiter(",");
                setNames(new String[] {
                        "jobNumber" ,
                        "docNumber" ,
                        "borough" ,
                        "houseNumber" ,
                        "streetName" ,
                        "block" ,
                        "lot" ,
                        "bin" ,
                        "jobType" ,
                        "jobStatus" ,
                        "jobStatusDescription" ,
                        "latestActionDate" ,
                        "buildingType" ,
                        "communityBoard" ,
                        "cluster" ,
                        "landmarked" ,
                        "adultEstablishment" ,
                        "loftBoard" ,
                        "cityOwned" ,
                        "littleE" ,
                        "pcFiled" ,
                        "eFilingFiled" ,
                        "plumbing" ,
                        "mechanical" ,
                        "boiler" ,
                        "fuelBurning" ,
                        "fuelStorage" ,
                        "standpipe" ,
                        "sprinkler" ,
                        "fireAlarm" ,
                        "equipment" ,
                        "fireSuppression" ,
                        "curbCut" ,
                        "other" ,
                        "otherDescription" ,
                        "applicantFirstName" ,
                        "applicantLastName" ,
                        "applicantProfessionalTitle" ,
                        "applicantLicenseNumber" ,
                        "professionalCert" ,
                        "preFilingDate" ,
                        "paidDate" ,
                        "fullyPaidDate" ,
                        "assignedDate" ,
                        "approvedDate" ,
                        "fullyPermittedDate" ,
                        "initialCost" ,
                        "totalEstimatedFee" ,
                        "feeStatus" ,
                        "existingSquareFootage" ,
                        "proposedSquareFootage" ,
                        "horizontalEnlargement" ,
                        "verticalEnlargement" ,
                        "enlargementSquareFootage" ,
                        "streetFrontage" ,
                        "existingStories" ,
                        "proposedStories" ,
                        "existingHeight" ,
                        "proposedHeight" ,
                        "existingUnits" ,
                        "proposedUnits" ,
                        "existingOccupancy" ,
                        "proposedOccupancy" ,
                        "siteFill" ,
                        "zoningDistrictOne" ,
                        "zoningDistrictTwo" ,
                        "zoningDistrictThree" ,
                        "specialDistrictOne" ,
                        "specialDistrictTwo" ,
                        "ownerType" ,
                        "nonProfit" ,
                        "ownerFirstName" ,
                        "ownerLastName" ,
                        "ownerBusinessName" ,
                        "ownerHouseNumber" ,
                        "ownerHouseStreetName" ,
                        "city" ,
                        "state" ,
                        "zip" ,
                        "ownerPhone" ,
                        "jobDescription" ,
                        "dobRunDate"
                });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Record>() {{
                setTargetType(Record.class);
            }});
        }});

        return reader;
    }

//    @Bean public ItemProcessor processor() {
//        return null;
//    }

    @Bean public ItemWriter<Record> writer(DataSource dataSource) {
        JdbcBatchItemWriter<Record> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO records (" +
                        "jobNumber," +
                        "docNumber," +
                        "borough," +
                        "houseNumber," +
                        "streetName," +
                        "block," +
                        "lot," +
                        "bin," +
                        "jobType," +
                        "jobStatus," +
                        "jobStatusDescription," +
                        "latestActionDate," +
                        "buildingType," +
                        "communityBoard," +
                        "cluster," +
                        "landmarked," +
                        "adultEstablishment," +
                        "loftBoard," +
                        "cityOwned," +
                        "littleE," +
                        "pcFiled," +
                        "eFilingFiled," +
                        "plumbing," +
                        "mechanical," +
                        "boiler," +
                        "fuelBurning," +
                        "fuelStorage" +
                        "standpipe," +
                        "sprinkler," +
                        "fireAlarm," +
                        "equipment," +
                        "fireSuppression," +
                        "curbCut," +
                        "other," +
                        "otherDescription," +
                        "applicantFirstName," +
                        "applicantLastName," +
                        "applicantProfessionalTitle," +
                        "applicantLicenseNumber," +
                        "professionalCert," +
                        "preFilingDate," +
                        "paidDate," +
                        "fullyPaidDate," +
                        "assignedDate," +
                        "approvedDate," +
                        "fullyPermittedDate," +
                        "initialCost," +
                        "totalEstimatedFee," +
                        "feeStatus," +
                        "existingSquareFootage," +
                        "proposedSquareFootage," +
                        "horizontalEnlargement," +
                        "verticalEnlargement," +
                        "enlargementSquareFootage," +
                        "streetFrontage," +
                        "existingStories," +
                        "proposedStories," +
                        "existingHeight," +
                        "proposedHeight," +
                        "existingUnits," +
                        "proposedUnits," +
                        "existingOccupancy," +
                        "proposedOccupancy," +
                        "siteFill," +
                        "zoningDistrictOne," +
                        "zoningDistrictTwo," +
                        "zoningDistrictThree," +
                        "specialDistrictOne," +
                        "specialDistrictTwo," +
                        "ownerType," +
                        "nonProfit," +
                        "ownerFirstName," +
                        "ownerLastName," +
                        "ownerBusinessName," +
                        "ownerHouseNumber," +
                        "ownerHouseStreetName," +
                        "city," +
                        "state," +
                        "zip," +
                        "ownerPhone," +
                        "jobDescription," +
                        "dobRunDate," +
                ") VALUES (" +
                        ":jobNumber," +
                        ":docNumber," +
                        ":borough," +
                        ":houseNumber," +
                        ":streetName," +
                        ":block," +
                        ":lot," +
                        ":bin," +
                        ":jobType," +
                        ":jobStatus," +
                        ":jobStatusDescription," +
                        ":latestActionDate," +
                        ":buildingType," +
                        ":communityBoard," +
                        ":cluster," +
                        ":landmarked," +
                        ":adultEstablishment," +
                        ":loftBoard," +
                        ":cityOwned," +
                        ":littleE," +
                        ":pcFiled," +
                        ":eFilingFiled," +
                        ":plumbing," +
                        ":mechanical," +
                        ":boiler," +
                        ":fuelBurning," +
                        ":fuelStorage" +
                        ":standpipe," +
                        ":sprinkler," +
                        ":fireAlarm," +
                        ":equipment," +
                        ":fireSuppression," +
                        ":curbCut," +
                        ":other," +
                        ":otherDescription," +
                        ":applicantFirstName," +
                        ":applicantLastName," +
                        ":applicantProfessionalTitle," +
                        ":applicantLicenseNumber," +
                        ":professionalCert," +
                        ":preFilingDate," +
                        ":paidDate," +
                        ":fullyPaidDate," +
                        ":assignedDate," +
                        ":approvedDate," +
                        ":fullyPermittedDate," +
                        ":initialCost," +
                        ":totalEstimatedFee," +
                        ":feeStatus," +
                        ":existingSquareFootage," +
                        ":proposedSquareFootage," +
                        ":horizontalEnlargement," +
                        ":verticalEnlargement," +
                        ":enlargementSquareFootage," +
                        ":streetFrontage," +
                        ":existingStories," +
                        ":proposedStories," +
                        ":existingHeight," +
                        ":proposedHeight," +
                        ":existingUnits," +
                        ":proposedUnits," +
                        ":existingOccupancy," +
                        ":proposedOccupancy," +
                        ":siteFill," +
                        ":zoningDistrictOne," +
                        ":zoningDistrictTwo," +
                        ":zoningDistrictThree," +
                        ":specialDistrictOne," +
                        ":specialDistrictTwo," +
                        ":ownerType," +
                        ":nonProfit," +
                        ":ownerFirstName," +
                        ":ownerLastName," +
                        ":ownerBusinessName," +
                        ":ownerHouseNumber," +
                        ":ownerHouseStreetName," +
                        ":city," +
                        ":state," +
                        ":zip," +
                        ":ownerPhone," +
                        ":jobDescription," +
                        ":dobRunDate," +
                ")");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean public Job readFile(JobBuilderFactory builder, Step read) {
        return builder.get("readFile").flow(read).end().build();
    }

    @Bean public Step read(StepBuilderFactory builder, ItemReader reader, ItemWriter writer/*,
                           ItemProcessor processor*/) {
        return builder.get("read")
                .chunk(1).reader(reader)
//                .processor(processor)
                .writer(writer).build();
    }

    @Bean JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:file:hsqldb");
        return dataSource;
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
    }
}
