package com.aotu.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.MemberDAO;
import com.aotu.entity.Member;
import com.aotu.entity.MemberCollector;
import com.aotu.entity.Page;
import com.aotu.service.IMemberService;
import com.aotu.util.Logger;
import com.weixin.utils.QRCodeUtils;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {

	protected Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MemberDAO memberDAO;

	// @Autowired
	// private IWeixinService weixinService;

	public void save(Member member) throws Exception {
		this.memberDAO.save(member);
	}

	public void delete(String id) throws Exception {
		this.memberDAO.delete(id);
	}

	public void update(Member member) throws Exception {
		this.memberDAO.update(member);
	}

	public Member get(String id) throws Exception {
		return (Member) this.memberDAO.get(id);
	}

	public Page queryPage(Page page, Member member) throws Exception {
		int totalRecordsNum = this.memberDAO.queryCount(member);
		page.setTotalRecordsNum(totalRecordsNum);

		List records = this.memberDAO.queryPage(page.getPageSize(), page.getStartIndex(), member);
		page.setRecords(records);
		return page;
	}

	public List<Member> queryList(Member member) throws Exception {
		List records = this.memberDAO.queryList(member);
		return records;
	}

	public Page queryUsb(Page page, Member member) throws Exception {
		int totalRecordsNum = this.memberDAO.queryCount(member);
		page.setTotalRecordsNum(totalRecordsNum);

		List records = this.memberDAO.queryPage(page.getPageSize(), page.getStartIndex(), member);
		page.setRecords(records);
		return page;
	}

	public List<Member> querySum(Member member) throws Exception {
		List records = this.memberDAO.querySum(member);
		return records;
	}

	public Member querySupMemberList(List<Member> memberList, String memberId) throws Exception {
		Member member = (Member) this.memberDAO.get(memberId);
		if ((member != null) && (member.getSuperiorMemberId() != null) && (!"".equals(member.getSuperiorMemberId()))) {
			Member supMember = (Member) this.memberDAO.get(member.getSuperiorMemberId());
			if (supMember != null) {
				memberList.add(supMember);
				querySupMemberList(memberList, supMember.getId());
			}

		}

		return null;
	}

	public int queryCount(Member member) throws Exception {
		int cou = this.memberDAO.queryCount(member);
		return cou;
	}

	public String generateQrCode(String memberId, HttpServletRequest request) throws Exception {
		Member memberTemp = this.get(memberId);
		String qrCodeUrl = memberTemp.getQrCodeUrl();
		if (qrCodeUrl == null || "".equals(qrCodeUrl)) {
			String filePath = request.getSession().getServletContext().getRealPath("uploadFiles") + "/";
			logger.info(" >>>>>>>>>> filePath <<<<<<<<<< " + filePath);
//			String fileUrl = "http://" + request.getServerName()  
//					+ "/uploadFiles/qrcode_logo.jpg";
			String fileUrl = "http://wx.xykdds.com/uploadFiles/qrcode_logo.jpg";
			if ("0".equals(memberTemp.getMemberType())) {// 代收人:跳转到添加代收人页面
//				String text = "http://" + request.getServerName() 
//						+ "/api/auth?urlType=4&memberId=" + memberId;
				String text = "http://wx.xykdds.com/api/auth?urlType=4&memberId=" + memberId;
//				fileUrl = "http://" + request.getServerName() 
//						+ "/uploadFiles/" + memberTemp.getId() + ".png";
				fileUrl = "http://wx.xykdds.com/uploadFiles/" + memberTemp.getId() + ".png";
				QRCodeUtils.generateQRCode(text, 180, 180, "png", filePath + memberTemp.getId() + ".png");
				memberTemp.setQrCodeUrl(fileUrl);
				this.update(memberTemp);
			}
			qrCodeUrl = fileUrl;
		}
		return qrCodeUrl;
	}

	public List<Member> queryMyCollector(Member member) throws Exception {
		return this.memberDAO.queryMyCollector(member);
	}
	
	public void saveMemberCollector(MemberCollector memberCollector) throws Exception {
		this.memberDAO.saveMemberCollector(memberCollector);
	}
	
	public List<MemberCollector> queryMemberCollectorList(MemberCollector memberCollector) throws Exception {
		return this.memberDAO.queryMemberCollectorList(memberCollector);
	}
}