package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSampleBatchApplication implements CommandLineRunner {

    private static final Logger LOGGER = LogManager.getLogger(SpringSampleBatchApplication.class);

	@Autowired
    private BulletinBoardDao bulletinBoardDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringSampleBatchApplication.class, args);
	}
	 @Override
	    public void run(String... strings) throws Exception {

	        LOGGER.info("START: バッチ処理を開始します");

	        //ここに処理を書く（daoのメソッド呼び出しなど）
	        int deleteCount = bulletinBoardDao.deleteOld();
	        LOGGER.info("削除件数：" + deleteCount);

	        LOGGER.info("END: バッチ処理が完了しました");
	    }
}
