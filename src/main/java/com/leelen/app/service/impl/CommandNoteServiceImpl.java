/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:18:31
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.leelen.app.repository.AdministratorRepository;
import com.leelen.app.repository.CommandNoteRepository;
import com.leelen.app.repository.MoblieUserRepository;
import com.leelen.app.repository.WyTokenRepository;
import com.leelen.app.service.CommandNoteService;
import com.leelen.entitys.CommandNote;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.Ramdata;

/**
 * @author xiaoxl
 *
 */
@Service
public class CommandNoteServiceImpl implements CommandNoteService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	CommandNoteRepository commandNoteRepository;

	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	WyTokenRepository wyTokenRepository;

	@Autowired
	MoblieUserRepository moblieUserRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CommandNoteService#save(com.leelen.entitys.
	 * CommandNote)
	 */
	@Override
	public RespEntity save(String token, String unit, String app, long timestamp, String sign) {// 不重复生成口令
		// TODO Auto-generated method stub
		// if (app == "wy" || app == "yz") {
		String strSign = "/app/command/productCommand?token=" + token + "&app=" + app + "&timestamp=" + timestamp;
		System.out.println(strSign);
		if (MyMethod.verdictSign(strSign, sign)) {
			CommandNote commandNote = new CommandNote();
			String command = Ramdata.ramdaSw(8);// 口令长度:8
			String createtime = MyMethod.getDate();
			String vDate = MyMethod.transferLongToDate("yyyy-MM-dd HH:mm:ss",
					new Date().getTime() + 24 * 60 * 60 * 1000);
			if (app.equals("wy")) {
				commandNote.setUid(wyTokenRepository.findByToken(token).getAid());
			}
			if (app.equals("yz")) {
				commandNote.setUid(moblieUserRepository.findByToken(token).getUid());
			}
			commandNote.setCreateid(Ramdata.ramdaSw(8));
			commandNote.setUnit(unit);
			commandNote.setCommand(command);
			commandNote.setIsuse(0);
			commandNote.setValidtime(vDate);
			commandNote.setCreatetime(createtime);
			commandNoteRepository.save(commandNote);

			JSONObject json = new JSONObject();
			json.put("commandValue", command);
			json.put("createtime", createtime);
			json.put("validtime", vDate);

			return new RespEntity(RespCode.SUCCESS, json);
		} else {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}
		// } else {
		// return new RespEntity(RespCode.Parameter_Error, null);
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.CommandNoteService#getCommandNoteByCreateid(java.lang
	 * .String)
	 */
	@Override
	public List<CommandNote> getCommandNoteByUid(String uid) {
		// TODO Auto-generated method stub
		return commandNoteRepository.findByUid(uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CommandNoteService#
	 * getCommandNoteByCreateidAndValidtime(java.lang.String, java.lang.String)
	 */
	@Override
	public CommandNote getCommandNoteByCreateidAndValidtime(String createid, String validtime) {
		// TODO Auto-generated method stub
		return commandNoteRepository.getCommandfindByCreateidAndValidtime(createid, validtime);
	}

	public boolean checkCommand(String createid, String validtime) {
		CommandNote commandNote = getCommandNoteByCreateidAndValidtime(createid, validtime);
		if (commandNote != null) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CommandNoteService#getCommandNote()
	 */
	@Override
	public List<CommandNote> getCommandNote() {
		// TODO Auto-generated method stub
		return commandNoteRepository.findAll();
	}

}
