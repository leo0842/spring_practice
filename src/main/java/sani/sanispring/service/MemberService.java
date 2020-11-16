package sani.sanispring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sani.sanispring.domain.Member;
import sani.sanispring.repository.MemberRepository;
import sani.sanispring.repository.MemoryMemberRepository;

public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Long join(Member member) {
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원");
        });
  }
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }
  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }

}
