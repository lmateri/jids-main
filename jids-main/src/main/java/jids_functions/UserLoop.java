package jids_functions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapNativeException;

import api.DbCheck;

class UserLoop{
   

    public static void startUp(String address) throws PcapNativeException, NotOpenException, IOException{
        boolean db = DbCheck.isAvailable();

        FileInputStream fis = new FileInputStream("./rules.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        
        if(!address.equals("offline")){
            OnlineInquiry.onlineAnalysis(br,db,address);
        }
        else{
            OfflineInquiry.offlineAnalysis(br,db);
        }
    }
}