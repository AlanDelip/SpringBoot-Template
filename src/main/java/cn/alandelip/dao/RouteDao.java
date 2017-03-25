package cn.alandelip.dao;

import cn.alandelip.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan on 2017/3/25
 */
public interface RouteDao extends JpaRepository<Route, Long> {
}
