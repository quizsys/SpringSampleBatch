package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BulletinBoardDao extends JpaRepository<BulletinBoardDto, Integer> {

	  /**
	   * deleteFlgをキーに検索する
	   */
	  @Query(value = "select * from TB_Board2 where delete_flg = :delete_flg order by update_date desc;" , nativeQuery = true)
	  List<BulletinBoardDto> findByDeleteFlg(@Param("delete_flg") boolean deleteFlg);

	  /**
	   * idをキーに検索する
	   */
	  @Query(value = "select * from TB_Board2 where id = :id" , nativeQuery = true)
	  BulletinBoardDto findById(@Param("id") int id);

	  /**
	   * idをキーにして、deleteFlgを更新する
	   * 更新処理の場合、@Modifyingと@Transactionalを付与すること
	   */
	  @Modifying
	  @Transactional
	  @Query(value = "update TB_Board2 set delete_flg = :delete_flg where id = :id" , nativeQuery = true)
	  void updateDeleteFlg(@Param("id") int id, @Param("delete_flg") boolean deleteFlg);

}