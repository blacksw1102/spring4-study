package spring;

import java.util.Date;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);

	}
	
}
