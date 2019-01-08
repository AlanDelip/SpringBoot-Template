package cn.alandelip.repository;

import cn.alandelip.entity.SampleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleDao extends JpaRepository<SampleData, Long> {
	SampleData findByName(String name);

	SampleData findByNameAndDetail(String name, String detail);

	@Query("from SampleData s where s.name=:name")
	SampleData findSample(@Param("name") String name);
}
