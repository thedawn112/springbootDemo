package com.example.demo.entity;

/**
 * @author ranran.mao
 * @date 2021/8/30 12:52
 */
public class TbClient {
    private long clientid;
    private String clientname;
    private int clientsex;
    private int clientnation;
    private String clientbirthdayaddress;
    private String identityid;
    private String address;
    private String reserve1;
    private String reserve2;
    private String reserve3;
    private String reserve4;

    public long getClientid() {
        return clientid;
    }

    public void setClientid(long clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public int getClientsex() {
        return clientsex;
    }

    public void setClientsex(int clientsex) {
        this.clientsex = clientsex;
    }

    public int getClientnation() {
        return clientnation;
    }

    public void setClientnation(int clientnation) {
        this.clientnation = clientnation;
    }

    public String getClientbirthdayaddress() {
        return clientbirthdayaddress;
    }

    public void setClientbirthdayaddress(String clientbirthdayaddress) {
        this.clientbirthdayaddress = clientbirthdayaddress;
    }

    public String getIdentityid() {
        return identityid;
    }

    public void setIdentityid(String identityid) {
        this.identityid = identityid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    @Override
    public String toString() {
        return "TbClient{" +
                "clientid=" + clientid +
                ", clientname='" + clientname + '\'' +
                ", clientsex=" + clientsex +
                ", clientnation=" + clientnation +
                ", clientbirthdayaddress='" + clientbirthdayaddress + '\'' +
                ", identityid='" + identityid + '\'' +
                ", address='" + address + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                ", reserve3='" + reserve3 + '\'' +
                ", reserve4='" + reserve4 + '\'' +
                '}';
    }
}
