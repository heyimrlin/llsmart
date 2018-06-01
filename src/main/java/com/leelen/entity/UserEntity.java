/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月19日下午2:16:42
 * @包名:com.leelen.entity
 * @描述:TODO
 */
package com.leelen.entity;

import java.util.LinkedList;
import java.util.List;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

/**
 * @author xiaoxl
 * ORM框架
 */
//@Entity
//@Table(name="user")
public class UserEntity extends BaseEntity {

	//用户名
		private String name;
		
		private String email;
		
		//性别 0: 女 1: 男 2:其他
		private int sex;
		
		//电话
		private String tel;
		
		//密码
		private String password;
		
		//地址信息
//		@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
//		private List<UserEntity> user = new LinkedList<UserEntity>();
//		
//		@OneToMany(mappedBy="blongUser")
//		private List<UserEntity> buser = new LinkedList<UserEntity>();

		public int getSex() {
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

//		public List<UserEntity> getUser() {
//			return user;
//		}
//
//		public void setUser(List<UserEntity> user) {
//			this.user = user;
//		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
}
