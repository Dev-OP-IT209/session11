# Bài 1: Khởi tạo Workflow chạy Unit Test tự động cho Java Spring Boot với Gradle

## Mục tiêu
- Thiết lập tệp cấu hình GitHub Actions Workflow `.github/workflows/ci.yml`.
- Tự động hóa quá trình chạy kiểm thử Unit Test (`./gradlew test`) mỗi khi có sự kiện `push` hoặc `pull_request` vào nhánh `main`.
- Lưu trữ báo cáo kết quả kiểm thử dưới dạng Artifact (`test-results`).

---

## 1. Cấu trúc Dự án
```text
ss11/b1/
├── .github/
│   └── workflows/
│       └── ci.yml              # Pipeline GitHub Actions CI
├── gradle/wrapper/             # Gradle wrapper
├── src/
│   ├── main/java/com/example/demo/DemoApplication.java
│   └── test/java/com/example/demo/DemoApplicationTests.java
├── build.gradle                # Cấu hình dependency Spring Boot
├── settings.gradle
├── gradlew
└── README.md
```

---

## 2. Giải thích Workflow CI
- **Triggers**: Kích hoạt tự động khi `push` hoặc tạo `pull_request` đến nhánh `main`.
- **Environment**: Chạy trên `ubuntu-latest`.
- **JDK Setup**: Sử dụng action `actions/setup-java@v4` cài đặt OpenJDK 17 (phân phối Eclipse Temurin).
- **Phân quyền thực thi**: Cấp quyền chạy cho wrapper script bằng lệnh `chmod +x gradlew`.
- **Kiểm thử**: Lệnh `./gradlew test --no-daemon` chạy toàn bộ JUnit 5 test cases.

---

## 3. Nhật ký Chạy CI Giả lập Thực tế
```bash
$ ./gradlew test

> Task :compileJava
> Task :processResources
> Task :classes
> Task :compileTestJava
> Task :processTestResources NO-SOURCE
> Task :testClasses
> Task :test

DemoApplicationTests > contextLoads() PASSED
DemoApplicationTests > testHelloEndpoint() PASSED

BUILD SUCCESSFUL in 4s
3 actionable tasks: 3 executed
```

---

## 4. Kết luận
Pipeline CI đảm bảo toàn bộ mã nguồn đẩy lên hệ thống được kiểm thử tự động, ngăn chặn các lỗi hồi quy trước khi merge code vào nhánh chính.
