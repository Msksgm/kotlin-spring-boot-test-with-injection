# kotlin-spring-boot-test-with-injection

## 概要

zenn に投稿した記事、「[Kotlin（Spring Boot）のテストコードで @SpringBootTest を利用して DI する](https://zenn.dev/msksgm/articles/20221118-kotlin-spring-boot-test-with-injection)」のサンプルコードです。
詳細は記事の方を参考にしてください。

## 起動方法

DB を起動。

```shell
docker compose up
```

テスト実行。

```shell
./gradlew test
```

DB を停止。

```shell
docker compose down
```
