package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSampleBatchApplication implements CommandLineRunner {

    @Autowired  //Daoの実装
    private BulletinBoardDao bulletinBoardDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringSampleBatchApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("START: バッチ処理を開始します");

        //ここに処理を書く（daoのメソッド呼び出しなど）
        List<BulletinBoardDto> dto = bulletinBoardDao.findByDeleteFlg(false);
        System.out.println("抽出結果は" + dto.size() + "件です");

        System.out.println("END: バッチ処理が完了しました");
    }
}
