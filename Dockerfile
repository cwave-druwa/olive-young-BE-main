# 베이스 이미지로 OpenJDK 17 사용
FROM openjdk:17-jdk

# 작업 디렉토리 설정
WORKDIR /app

# 빌드 시 전달된 DB_URL 값을 받는 ARG
ARG DB_URL

# 환경 변수 설정: 런타임에 사용할 수 있도록 ARG 값을 ENV로 전달
ENV TZ=Asia/Seoul \
    DB_URL=${DB_URL}

# 포트 설정
EXPOSE 8080

# 애플리케이션 JAR 파일 복사
COPY build/libs/young-0.0.1-SNAPSHOT.jar /app

# 애플리케이션 실행
CMD ["java", "-jar", "young-0.0.1-SNAPSHOT.jar"]
