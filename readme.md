올리브영 프로젝트의 메인 페이지 기능을 담당하는 서버입니다.</p>
메인 페이지의 물건 리스트를 반환하는 간단한 기능이 구현되어 있습니다.

`Gitlab`을 이용한 코드 관리를 했기 때문에 자동화는 [`.gitlab-ci.yml`](.gitlab-ci.yml)을 통해 진행 되었습니다.

자동화 파이프라인은 총 6개로 이뤄져 있습니다.

```
- build
- sonarqube-check
- dockerize_korea
- dockerize_dr
- push_to_ecr_korea
- push_to_ecr_dr
```