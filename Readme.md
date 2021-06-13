ЗАПУСКАЕМ БАЗУ POSTGRESQL В КОНТЕЙНЕРЕ
Скачаем образ postgres:13.2-alpine:
$ docker pull postgres:13.2-alpine
запускаем контейнеризацию:
$ docker build -t frtest
запускаем бд:
$ docker run --rm -it -p  5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=12345 -e POSTGRES_DB=fr_test_app postgres:13.2-alpine
Обратите внимание на опции:

-e POSTGRES_USER=postgres
-e POSTGRES_PASSWORD=12345
-e POSTGRES_DB=fr_test_app
