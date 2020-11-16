package sani.sanispring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sani.sanispring.repository.MemberRepository;
import sani.sanispring.repository.MemoryMemberRepository;
import sani.sanispring.service.MemberService;


@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}
