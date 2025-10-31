package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractDataManager {
    private final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract){
        try {

            if (contract == null){
                System.out.println("Wrong Input");
                return;
            }

            Vehicle vehicle = contract.getVehicleSold();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));

            String financeOption = "";
            if (contract instanceof SalesContract){
                if (((SalesContract)contract).isFinanceOption()){
                    financeOption = "Yes";
                } else if (!((SalesContract)contract).isFinanceOption()) {
                    financeOption = "No";
                }
                bufferedWriter.write("SALES" + "|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" + vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                        + "|" + vehicle.getPrice() + "|" + (((SalesContract) contract).getSalesTaxAmount()) + "|" + ((SalesContract) contract).getRecordingFee() + "|"
                        + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + ((SalesContract) contract).isFinanceOption() + "|"
                        + contract.getMonthlyPayment()
                        );
                bufferedWriter.newLine();
            } else if (contract instanceof LeaseContract) {
                bufferedWriter.write("LEASE" + "|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|"
                        + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake()
                        + "|" + contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor()
                        + "|" + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice() + "|" + ((LeaseContract) contract).getExpectedEndingValue()
                        + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + "|" + contract.getMonthlyPayment()
                );
                bufferedWriter.newLine();
            }
            System.out.println("Done");
            bufferedWriter.close();

        }catch (Exception ex){
            System.err.println("Error in ContractDataManager...");
        }
    }
}
