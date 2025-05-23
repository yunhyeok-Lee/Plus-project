package com.shoppingmall.domain.openapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class OpenApiDto {

    //오픈 api 서버에서 가져온 데이터를 우선적으로 받는 dto
    private String storeName;
    private String mailName;
    private String domainName;
    private String address;
    private String status;
    private Long phoneNumber;
    private Long rating;
    private LocalDateTime monitoredAt;
//    private String COMPANY;
//    private String SHOP_NAME;
//    private String DOMAIN_NAME;
//    private String TEL;
//    private String EMAIL;
//    private String UPJONG_NBR;
//    private String YPFORM;
//    private String FIRST_HEO_DATE;
//    private String COM_ADDR;
//    private String STAT_NM;
//    private int TOT_RATINGPOINT;
//    private int CHOGI_RATINGPOINT;
//    private int CHUNG_RATINGPOINT;
//    private int DEAL_RATINGPOINT;
//    private int PYOJUN_RATINGPOINT;
//    private int SECURITY_RATINGPOINT;
//    private String SERVICE;
//    private String CHUNG;
//    private String CHOGI;
//    private String GYULJE;
//    private String PYOJUN;
//    private String P_INFO_CARE;
//    private String PER_INFO;
//    private String DEAL_CARE;
//    private String SSL_YN;
//    private String INJEUNG;
//    private String BAESONG_YEJEONG;
//    private String BAESONG;
//    private String CLIENT_BBS;
//    private String LEAVE;
//    private String KAESOL_YEAR;
//    private String REG_DATE;


}
