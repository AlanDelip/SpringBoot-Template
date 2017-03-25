package cn.alandelip.dao;

import cn.alandelip.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan on 2017/3/25
 */
public interface PointDao extends JpaRepository<Point, Long> {
}
