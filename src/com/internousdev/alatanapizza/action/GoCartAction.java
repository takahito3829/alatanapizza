package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware,ErrorMessageConstants{

	Map<Strint, Object>session;
	ArrayList<CartInfoDTO>cartList = new ArrayList<>();
	int totalPrice;

	public String execute() throws SQLException{

		CartInfoDAO dao = new CartInfoDAO();

	//合計金額の計算
		totalPrice = calcTotalPrice(cartList);
		return SUCCESS;
	}

	public Map<String, Object>getSession(){
		return session;
	}

	public void setSession(Map<String, Object>session){
		this.session = session;
	}

	public ArrayList<CartInfoDTO>getCartList(){
		return cartList;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	//合計金額を計算するメソッド
	public int calcTotalPrice(ArrayList<CartInfoDTO>cartList){
		int totalPrice = 0;
		for(CartInfoDTO dto:cartList){
			totalPrice += dto.getPrice() * dto.getProductCount();
			System.out.println("合計" + totalPrice + "円");
		}
	}

}