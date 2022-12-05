package com.mc.springxml.utils;

public class EventCode {
	
	//SUCCESS CODE
    public static String[] SUCCESS_000 = {"S000","success"}; // 정상 성공 
    public static String[] SUCCESS_001 = {"S001","정상 성공이나 데이터는 없음"}; // 정상 성공이나 데이터는 없음
    public static String[] SUCCESS_002 = {"S002","이미 데이터가 존재함"}; // 이미 데이터가 존재함 
	
	//ERROR CODE
	public static String[] ERROR_000 = {"E000","fail"}; // 오류 
    public static String[] ERROR_001 = {"E001","DB 오류 "}; // DB 오류 
    public static String[] ERROR_002 = {"E002","아이디가 존재합니다."}; // 아이디 존재
    public static String[] ERROR_003 = {"E003","아이디가 존재하지 않거나 패스워드가 맞지 않습니다."}; // 아이디가 존재하지 않거나 패스워드가 맞지 않습니다
    public static String[] ERROR_004 = {"E004","인증되지 않은 계정"}; // 인증되지 않은 계정
    public static String[] ERROR_005 = {"E005","삭제 오류"}; // 삭제 오류
    public static String[] ERROR_999 = {"E999","알수 없는 오류"}; // 알수 없는 오류

}
