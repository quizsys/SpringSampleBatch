package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BulletinBoardDao extends JpaRepository<BulletinBoardDto, Integer> {

	  /**
	   * データを削除する
	   * 条件１: 更新日時が3か月以上前であること
	   * 条件2: 削除フラグがtrueであること
	   * 更新処理の場合、@Modifyingと@Transactionalを付与すること
	   * @return 削除件数
	   */
	  @Modifying
	  @Transactional
	  @Query(value = "DELETE FROM tb_board WHERE delete_flg = true and (update_date < NOW() - INTERVAL 3 MONTH)" , nativeQuery = true)
	  int deleteOld();

}