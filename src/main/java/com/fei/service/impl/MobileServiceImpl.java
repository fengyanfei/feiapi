package com.fei.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fei.bean.Advert;
import com.fei.bean.AdvertExample;
import com.fei.bean.ApartmentNewExample;
import com.fei.bean.AreaExample;
import com.fei.bean.BankRate;
import com.fei.bean.BankRateExample;
import com.fei.bean.BaseInfo;
import com.fei.bean.BaseInfoExample;
import com.fei.bean.Building;
import com.fei.bean.BuildingFile;
import com.fei.bean.BuildingFileExample;
import com.fei.bean.BuildingOld;
import com.fei.bean.Client;
import com.fei.bean.ClientExample;
import com.fei.bean.Developers;
import com.fei.bean.LoanOrder;
import com.fei.bean.LoanOrderExample;
import com.fei.bean.Mortgage;
import com.fei.bean.MortgageExample;
import com.fei.bean.Order;
import com.fei.bean.OrderExample;
import com.fei.bean.Problem;
import com.fei.bean.ProblemExample;
import com.fei.bean.Property;
import com.fei.bean.Result;
import com.fei.bean.SecondHouseOrder;
import com.fei.bean.SecondHouseOrderExample;
import com.fei.bean.BuildingFileExample.Criteria;
import com.fei.dao.AdvertMapper;
import com.fei.dao.ApartmentNewMapper;
import com.fei.dao.AreaMapper;
import com.fei.dao.BankRateMapper;
import com.fei.dao.BaseInfoMapper;
import com.fei.dao.BuildingFileMapper;
import com.fei.dao.BuildingMapper;
import com.fei.dao.BuildingOldMapper;
import com.fei.dao.ClientMapper;
import com.fei.dao.DevelopersMapper;
import com.fei.dao.LoanOrderMapper;
import com.fei.dao.MortgageMapper;
import com.fei.dao.OrderMapper;
import com.fei.dao.ProblemMapper;
import com.fei.dao.PropertyMapper;
import com.fei.dao.SecondHouseOrderMapper;
import com.fei.service.MobileService;
import com.fei.util.AverageCapitalPlusInterestUtils;
import com.fei.util.AverageCapitalUtils;
import com.fei.util.PinYinUtils;
import com.fei.util.StringUtils;
import com.fei.util.Utils;
import com.fei.vo.BuildingOldVo;
import com.fei.vo.BuildingVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MobileServiceImpl implements MobileService {

	private static Map<String, String> baseInfoMap = new HashMap<>();

	@Autowired
	private BuildingMapper buildingMapper;

	@Autowired
	private BuildingFileMapper buildingFileMapper;

	@Autowired
	private BaseInfoMapper baseInfoMapper;

	@Autowired
	private ApartmentNewMapper apartmentMapper;

	@Autowired
	private AreaMapper areaMapper;

	@Autowired
	private AdvertMapper advertMapper;
	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private ProblemMapper problemMapper;
	@Autowired
	private BankRateMapper bankRateMapper;
	@Autowired
	private LoanOrderMapper loanOrderMapper;
	@Autowired
	private SecondHouseOrderMapper secondHouseOrderMapper;
	@Autowired
	private BuildingOldMapper buildingOldMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private MortgageMapper mortgageMapper;
	@Autowired
	private PropertyMapper propertyMapper;
	@Autowired
	private DevelopersMapper developersMapper;

	@Override
	public Result getBuildingListByPage(BuildingVo vo) {
		Result result = new Result();
		PageHelper.startPage(vo.getStartPage(), vo.getPageSize());
		List<Map<String, Object>> buildings = buildingMapper.getBuildingList(vo);

		for (Map<String, Object> map : buildings) {
			// 封裝装修情况
			map.put("decorateSituationName", getBaseInfoValue("decorateSituation" + map.get("decorateSituation")));
			// 获取楼盘图片信息
			BuildingFileExample example = new BuildingFileExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andBuildingIdEqualTo(map.get("buildingId").toString());
			createCriteria.andDeleteFlagEqualTo(0);
			example.setOrderByClause("isThumbnail desc");
			List<BuildingFile> buildFiles = buildingFileMapper.selectByExample(example);
			List<String> fileList = new ArrayList<>();
			if (buildFiles == null || buildFiles.size() == 0) {
				map.put("thumbnail", null);
			} else {
				for (int i = 0; i < buildFiles.size(); i++) {
					if (i == 0) {
						map.put("thumbnail", buildFiles.get(i).getFilePath());
					}
					fileList.add(buildFiles.get(i).getFilePath());
				}
			}

			map.put("buildFiles", fileList);
		}

		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(buildings);
		int total = (int) pageInfo.getTotal();
		result.setTotalSize(total);
		result.setData(buildings);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result getBaseInfo(BaseInfo info) {
		Result result = new Result();
		BaseInfoExample example = new BaseInfoExample();
		BaseInfoExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDataStatusEqualTo(1)
				.andDeleteFlagEqualTo(0);
		if (!StringUtils.isEmpty(info.getCodeId())) {
			andDeleteFlagEqualTo.andCodeIdEqualTo(info.getCodeId());
			result.setData(baseInfoMapper.selectByExample(example));
		} else if (!StringUtils.isEmpty(info.getCodeId()) && !StringUtils.isEmpty(info.getCodeKey())) {
			andDeleteFlagEqualTo.andCodeIdEqualTo(info.getCodeId()).andCodeKeyEqualTo(info.getCodeKey());
			result.setData(baseInfoMapper.selectByExample(example));
		} else {
			result.setData(baseInfoMapper.selectByExample(example));
		}
		result.setStatus(Result.SUCCESS);
		return result;
	}

	private String getBaseInfoValue(String key) {
		if (baseInfoMap.size() > 0) {
			return baseInfoMap.get(key);
		} else {
			BaseInfoExample example = new BaseInfoExample();
			BaseInfoExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDataStatusEqualTo(1)
					.andDeleteFlagEqualTo(0);
			List<BaseInfo> infos = baseInfoMapper.selectByExample(example);
			for (BaseInfo info : infos) {
				baseInfoMap.put(info.getCodeId() + info.getCodeKey(), info.getCodeValue());
			}
			return baseInfoMap.get(key);
		}

	}

	@Override
	public Result getApartment(String buildingId) {
		Result result = new Result();
		if (!StringUtils.isEmpty(buildingId)) {
			ApartmentNewExample example = new ApartmentNewExample();
			example.setOrderByClause("updateTime desc");
			example.createCriteria().andShelvesEqualTo(1).andDeleteFlagEqualTo(0).andBuildingIdEqualTo(buildingId);
			List<Map<String, Object>> selectByExample = apartmentMapper.selectByExample(example);
			for (Map<String, Object> map : selectByExample) {
				// 拼接户型组成
				String s = "";
				if (!StringUtils.isEmpty(map.get("bedroom"))) {
					s = StringUtils.numberToBig((int) map.get("bedroom")) + "室";
				}
				if (!StringUtils.isEmpty(map.get("livingRoom"))) {
					s += StringUtils.numberToBig((int) map.get("livingRoom")) + "厅";
				}
				if (!StringUtils.isEmpty(map.get("toltel"))) {
					s += StringUtils.numberToBig((int) map.get("toltel")) + "卫";
				}
				if (!StringUtils.isEmpty(map.get("kitchen"))) {
					s += StringUtils.numberToBig((int) map.get("kitchen")) + "厨";
				}
				map.put("apartmentName", s);

				map.put("decorateSituationName", getBaseInfoValue("decorateSituation" + map.get("decorateSituation")));
				BuildingFileExample fileExample = new BuildingFileExample();
				Criteria createCriteria = fileExample.createCriteria();
				createCriteria.andBuildingIdEqualTo(map.get("apartmentId").toString());
				createCriteria.andDeleteFlagEqualTo(0);
				example.setOrderByClause("isThumbnail desc");
				List<BuildingFile> buildFiles = buildingFileMapper.selectByExample(fileExample);
				List<String> fileList = new ArrayList<>();
				if (buildFiles == null || buildFiles.size() == 0) {
					map.put("thumbnail", null);
				} else {
					for (int i = 0; i < buildFiles.size(); i++) {
						if (i == 0) {
							map.put("thumbnail", buildFiles.get(i).getFilePath());
						}
						fileList.add(buildFiles.get(i).getFilePath());
					}
				}

				map.put("buildFiles", fileList);
			}
			result.setData(selectByExample);
			result.setStatus(Result.SUCCESS);
		}

		return result;
	}

	@Override
	public Result getBuildingDetail(String buildingId, String userId) {
		Result result = new Result();
		if (!StringUtils.isEmpty(buildingId)) {
			Building building = buildingMapper.selectByPrimaryKey(buildingId);
			if (building == null) {
				building = new Building();
			}
			Property property = propertyMapper.selectByPrimaryKey(building.getPropertyCompany());
			Developers developers = developersMapper.selectByPrimaryKey(building.getDevelopers());

			List<HashMap<String, Object>> params = new ArrayList<>();
			for (int i = 0; i < 8; i++) {
				HashMap<String, Object> param = new HashMap<>();
				switch (i) {
				case 0:
					param.put("param1",
							"地址：" + (building.getDetailAddress() == null ? "" : building.getDetailAddress()));
					break;
				case 1:
					param.put("param1", "开发商：" + (developers == null ? "" : developers.getDevelopeName()));
					break;
				case 2:
					param.put("param1", "物业公司：" + (property == null ? "" : property.getPropertyName()));
					break;
				case 3:
					String proType = "";
					if (building.getPropertyType() != null) {
						String[] split = building.getPropertyType().split(",");
						if (split != null) {
							for (int j = 0; j < split.length; j++) {
								proType += getBaseInfoValue("propertyType" + split[j]);
								if (j != split.length - 1) {
									proType += ",";
								}
							}
						}
					}
					param.put("param1", "物业类型：" + proType);
					param.put("param2", "装修情况：" + (building.getDecorateSituation() == null ? ""
							: getBaseInfoValue("decorateSituation" + building.getDecorateSituation())));
					break;
				case 4:
					param.put("param1",
							"占地面积：" + (building.getCoversArea() == null ? "" : building.getCoversArea() + "平方米"));
					param.put("param2",
							"建筑面积：" + (building.getBuildingArea() == null ? "" : building.getBuildingArea() + "平方米"));
					break;
				case 5:
					param.put("param1",
							"商业面积：" + (building.getBusinessArea() == null ? "" : building.getBusinessArea() + "平方米"));
					param.put("param2",
							"物业费：" + (building.getPropertyCost() == null ? "" : building.getPropertyCost() + "元"));
					break;
				case 6:
					param.put("param1", "总户数：" + (building.getTotalHosing() == null ? "" : building.getTotalHosing()));
					param.put("param2", "容积率：" + (building.getPlotRatio() == null ? "" : building.getPlotRatio()));
					break;
				case 7:
					param.put("param1", "绿化率：" + (building.getGreenRate() == null ? "" : building.getGreenRate()));
					param.put("param2", "梯户比："
							+ (building.getElevatorProportion() == null ? "" : building.getElevatorProportion()));
					break;
				case 8:
					param.put("param1",
							"车位数：" + (building.getParkingNumber() == null ? "" : building.getParkingNumber()));
					param.put("param2",
							"车库数：" + (building.getGarageNumber() == null ? "" : building.getGarageNumber()));
					break;
				}

				params.add(param);
			}
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("params", params);
			// 查询楼盘统计数据
			OrderExample example = new OrderExample();
			example.createCriteria().andDeleteFlagEqualTo(0).andBuildingIdEqualTo(buildingId);
			List<Order> orders = orderMapper.selectByExample(example);
			Set<String> agentNum = new HashSet<>();
			Set<String> intentClientNum = new HashSet<>();
			Set<String> myClientNum = new HashSet<>();
			for (Order order : orders) {
				agentNum.add(order.getAgentId());
				intentClientNum.add(order.getClientId());
				if (order.getAgentId() != null && order.getAgentId().equals(userId) && order.getBuildingId() != null
						&& order.getBuildingId().equals(buildingId)) {
					myClientNum.add(order.getClientId());
				}
			}
			HashMap<String, Integer> num = new HashMap<>();
			num.put("agentNum", agentNum.size());// 合作经纪人数量
			num.put("intentClientNum", intentClientNum.size());// 意向客户数量
			num.put("myClientNum", myClientNum.size());// 我的客户数量
			resultMap.put("num", num);
			result.setData(resultMap);
			result.setStatus(Result.SUCCESS);
		}

		return result;
	}

	@Override
	public Result getCity(String code, String cityName) {
		Result result = new Result();

		if (StringUtils.isEmpty(code) && StringUtils.isEmpty(cityName)) { // 获取城市列表
			List<Map<String, Object>> indexs = areaMapper.getIndex(null);

			AreaExample example = new AreaExample();
			example.createCriteria().andArealevalEqualTo("1");
			example.setOrderByClause(" firstalpha asc");
			List<Map<String, String>> selectByExample = areaMapper.selectByExample(example);
			for (Map<String, Object> index : indexs) {
				List<Map<String, String>> citys = new ArrayList<>();
				for (Map<String, String> area : selectByExample) {
					if (index.get("index").equals(area.get("firstalpha"))) {
						citys.add(area);
					}
				}
				index.put("citys", citys);
			}

			// 热门城市
			List<Map<String, Object>> hotCitys = areaMapper.getIndex("1");
			Map<String, Object> hotCity = new HashMap<>();
			hotCity.put("index", "热门");
			hotCity.put("citys", hotCitys);
			indexs.add(0, hotCity);

			result.setData(indexs);
			result.setStatus(Result.SUCCESS);
		} else { // 获取所在城市下区

			AreaExample example = new AreaExample();
			if (!StringUtils.isEmpty(code)) {
				example.createCriteria().andArealevalEqualTo("2").andParentcodeEqualTo(code);
			}
			if (!StringUtils.isEmpty(cityName)) {
				AreaExample example1 = new AreaExample();
				example1.createCriteria().andArealevalEqualTo("1").andAreanameEqualTo(cityName);
				List<Map<String, String>> cityMap = areaMapper.selectByExample(example1);
				if (cityMap != null && cityMap.size() > 0) {
					Map<String, String> map = cityMap.get(0);
					String areacode = String.valueOf(map.get("areacode"));
					example.createCriteria().andArealevalEqualTo("2").andParentcodeEqualTo(areacode);
				}
			}
			example.setOrderByClause(" firstalpha asc");
			List<Map<String, String>> selectByExample = areaMapper.selectByExample(example);
			result.setData(selectByExample);
			result.setStatus(Result.SUCCESS);
		}

		return result;
	}

	@Override
	public Result getAdvert(Integer advType) {
		Result result = new Result();
		AdvertExample example = new AdvertExample();
		if (advType != null) {
			example.createCriteria().andAdvertTypeEqualTo(advType);
		}
		example.createCriteria().andDeleteFlagEqualTo(0).andEnableFlagEqualTo(1);
		example.setOrderByClause("sequence asc");

		List<Advert> selectByExample = advertMapper.selectByExample(example);
		result.setData(selectByExample);
		result.setStatus(Result.SUCCESS);

		return result;
	}

	@Override
	public Result getClient(String agentId) {
		Result result = new Result();
		if (!StringUtils.isEmpty(agentId)) {
			ClientExample example = new ClientExample();
			example.createCriteria().andAgentIdEqualTo(agentId).andDeleteFlagEqualTo(0);
			example.setOrderByClause("firstAlpha asc");
			List<Map<String, String>> selectByExample = clientMapper.selectByExample(example);

			List<Map<String, Object>> indexs = clientMapper.getIndex(agentId);

			List<Map<String, String>> otherClients = new ArrayList<>();
			for (Map<String, Object> index : indexs) {
				List<Map<String, String>> clients = new ArrayList<>();

				for (Map<String, String> client : selectByExample) {
					// if (index.get("index").equals("#")) {
					// otherClients.add(client);
					// }else{
					if (index.get("index").equals(client.get("firstAlpha"))) {
						clients.add(client);
					}
					// }

				}
				index.put("clients", clients);
			}
			// if (otherClients.size() != 0) {
			// Map<String,Object> otherMap = new HashMap<>();
			// otherMap.put("clients", otherClients);
			// otherMap.put("index", "#");
			// indexs.add(otherMap);
			// }

			result.setData(indexs);
			result.setStatus(Result.SUCCESS);
		}

		return result;
	}

	@Override
	public Result addClient(Client client) {
		Result result = new Result();
		if (client != null && !StringUtils.isEmpty(client.getAgentId())) {
			client.setClientId(Utils.getUUID());
			client.setCreateUser(client.getAgentId());
			client.setCreateTime(new Date());
			client.setDeleteFlag(0);
			// client.setAgentId("1");
			if (!StringUtils.isEmpty(client.getClientName())) {
				client.setFirstAlpha(PinYinUtils.getFirstSpell(client.getClientName().substring(0, 1)).toUpperCase());
			} else {
				client.setFirstAlpha("#");
			}

			clientMapper.insert(client);
			result.setStatus(Result.SUCCESS);
			result.setData(client);
			result.setMsg("添加成功");
		}

		return result;
	}

	@Override
	public Result getProblem(Integer userCategory) {
		Result result = new Result();
		ProblemExample example = new ProblemExample();
		List<Integer> values = new ArrayList<>();
		values.add(2);
		values.add(userCategory);
		example.createCriteria().andDeleteFlagEqualTo(0).andProblemTypeIn(values);
		example.setOrderByClause("createTime desc");
		List<Problem> selectByExample = problemMapper.selectByExampleWithBLOBs(example);
		result.setData(selectByExample);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result getBankRate() {
		Result result = new Result();
		BankRateExample example = new BankRateExample();
		example.createCriteria().andDeleteFlagEqualTo(0);
		example.setOrderByClause("createTime desc");

		List<BankRate> selectByExample = bankRateMapper.selectByExample(example);
		result.setData(selectByExample);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result getLoanOrder(LoanOrder order) {
		Result result = new Result();
		LoanOrderExample example = new LoanOrderExample();
		LoanOrderExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0);
		if (!StringUtils.isEmpty(order.getAgentId())) {
			andDeleteFlagEqualTo.andAgentIdEqualTo(order.getAgentId());
		}
		example.setOrderByClause("createTime desc");
		List<LoanOrder> selectByExample = loanOrderMapper.selectByExample(example);
		result.setData(selectByExample);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result addLoanOrder(LoanOrder order) {
		Result result = new Result();
		if (order != null) {
			order.setLoanOrderId(Utils.getUUID());
			order.setCreateTime(new Date());
			order.setDeleteFlag(0);
			order.setApproveProgress(0);

			loanOrderMapper.insert(order);
			result.setStatus(Result.SUCCESS);
			result.setData(order);
			result.setMsg("添加成功");
		}

		return result;
	}

	@Override
	public Result getSecondHouseOrder(SecondHouseOrder vo) {
		Result result = new Result();
		SecondHouseOrderExample example = new SecondHouseOrderExample();
		SecondHouseOrderExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0);
		if (!StringUtils.isEmpty(vo.getAgentId())) {
			andDeleteFlagEqualTo.andAgentIdEqualTo(vo.getAgentId());
		}
		example.setOrderByClause("createTime desc");

		List<SecondHouseOrder> selectByExample = secondHouseOrderMapper.selectByExample(example);
		result.setData(selectByExample);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result addSecondHouseOrder(SecondHouseOrder order) {
		Result result = new Result();
		if (order != null) {
			order.setSecOrderId(Utils.getUUID());
			order.setCreateTime(new Date());
			order.setDeleteFlag(0);
			order.setApproveProgress(0);

			secondHouseOrderMapper.insert(order);
			result.setStatus(Result.SUCCESS);
			result.setData(order);
			result.setMsg("添加成功");
		}

		return result;
	}

	@Override
	public Result getBuildingOldListByPage(BuildingOldVo buildOld) {
		Result result = new Result();
		PageHelper.startPage(buildOld.getStartPage(), buildOld.getPageSize());
		List<Map<String, Object>> buildings = buildingOldMapper.getBuildingList(buildOld);

		for (Map<String, Object> map : buildings) {
			// 封裝装修情况
			map.put("decorateSituationName", getBaseInfoValue("decorateSituation" + map.get("decorateSituation")));
			// 获取楼盘图片信息
			BuildingFileExample example = new BuildingFileExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andBuildingIdEqualTo(map.get("buildingOldId").toString());
			createCriteria.andDeleteFlagEqualTo(0);
			example.setOrderByClause("isThumbnail desc");
			List<BuildingFile> buildFiles = buildingFileMapper.selectByExample(example);
			List<String> fileList = new ArrayList<>();
			if (buildFiles == null || buildFiles.size() == 0) {
				map.put("thumbnail", null);
			} else {
				for (int i = 0; i < buildFiles.size(); i++) {
					if (i == 0) {
						map.put("thumbnail", buildFiles.get(i).getFilePath());
					}
					fileList.add(buildFiles.get(i).getFilePath());
				}
			}

			map.put("buildFiles", fileList);
		}

		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(buildings);
		int total = (int) pageInfo.getTotal();
		result.setTotalSize(total);
		result.setData(buildings);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result calculateLoan(double invest, int totalMonth, double yearRate, int type) {
		Result result = new Result();

		result.setData(type == 0 ? averageCapitalPlusInterest(invest, totalMonth, yearRate)
				: averageCapital(invest, totalMonth, yearRate));
		result.setStatus(Result.SUCCESS);
		return result;
	}

	private HashMap<String, Object> averageCapitalPlusInterestCombination(double accInvest, double accYearRate,
			int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> yearsList = new ArrayList<>();
		List<List<Integer>> listValues = new ArrayList<>();
		Map<String, Object> yearsMap = new HashMap<>();
		int totalInterest = 0;

		// 本金
		Map<Integer, BigDecimal> princiMap = AverageCapitalPlusInterestUtils.getCombinationPerMonthPrincipal(accInvest,
				accYearRate, accTotalmonth, busInvest, busYearRate, busTotalmonth);
		// 利息
		Map<Integer, BigDecimal> interestMap = AverageCapitalPlusInterestUtils.getCombinationPerMonthInterest(accInvest,
				accYearRate, accTotalmonth, busInvest, busYearRate, busTotalmonth);
		// 每月还款
		Map<Integer, BigDecimal> everyPriceMap = AverageCapitalPlusInterestUtils
				.getCombinationPerMonthPrincipalInterest(accInvest, accYearRate, accTotalmonth, busInvest, busYearRate,
						busTotalmonth);
		// 总和（本金+利息）
		double principalInterestCount = AverageCapitalPlusInterestUtils.getCombinationPrincipalInterestCount(accInvest,
				accYearRate, accTotalmonth, busInvest, busYearRate, busTotalmonth);
		// 每月应还金额
		BigDecimal alreadyPrice = new BigDecimal(Double.toString(0.0));
		int every = 0;
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {

			List<Integer> listValue = new ArrayList<>();
			listValue.add(i);
			every += everyPriceMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			listValue.add(everyPriceMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			listValue.add(princiMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			totalInterest += interestMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			listValue.add(interestMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			alreadyPrice = alreadyPrice.add(everyPriceMap.get(i));
			int intPrice = alreadyPrice.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			if (i == maxMonth) {
				listValue.add(0);
			} else {
				listValue.add((new BigDecimal(principalInterestCount).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue()
						- intPrice);
			}

			listValues.add(listValue);
			if (i % 12 == 0) {
				yearsMap.put("year", "第" + i / 12 + "年");
				yearsMap.put("record", listValues);
				yearsList.add(yearsMap);
				listValues = new ArrayList<>();
				yearsMap = new HashMap<>();
			}
		}
		resultMap.put("detail", yearsList);
		resultMap.put("totalInterest", totalInterest);
		resultMap.put("everyPrice", every / maxMonth + "元/月");
		return resultMap;
	}

	private HashMap<String, Object> averageCapitalPlusInterest(double invest, int totalMonth, double yearRate) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> yearsList = new ArrayList<>();
		List<List<Integer>> listValues = new ArrayList<>();
		Map<String, Object> yearsMap = new HashMap<>();
		int totalInterest = 0;

		// 本金
		Map<Integer, BigDecimal> princiMap = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(invest, yearRate,
				totalMonth);
		// 利息
		Map<Integer, BigDecimal> interestMap = AverageCapitalPlusInterestUtils.getPerMonthInterest(invest, yearRate,
				totalMonth);
		// 每月还款
		BigDecimal everyPrice = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(invest, yearRate,
				totalMonth);
		// 总和（本金+利息）
		double principalInterestCount = AverageCapitalPlusInterestUtils.getPrincipalInterestCount(invest, yearRate,
				totalMonth);
		// 每月应还金额
		BigDecimal alreadyPrice = new BigDecimal(Double.toString(0.0));
		int every = 0;

		for (int i = 1; i <= totalMonth; i++) {

			List<Integer> listValue = new ArrayList<>();
			listValue.add(i);
			every = everyPrice.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			listValue.add(every);
			listValue.add(princiMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			totalInterest += interestMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			listValue.add(interestMap.get(i).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
			alreadyPrice = alreadyPrice.add(everyPrice);
			int intPrice = alreadyPrice.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
			listValue.add((new BigDecimal(principalInterestCount).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue()
					- intPrice);
			listValues.add(listValue);
			if (i % 12 == 0) {
				yearsMap.put("year", "第" + i / 12 + "年");
				yearsMap.put("record", listValues);
				yearsList.add(yearsMap);
				listValues = new ArrayList<>();
				yearsMap = new HashMap<>();
			}
		}
		resultMap.put("detail", yearsList);
		resultMap.put("totalInterest", totalInterest);
		resultMap.put("everyPrice", every + "元/月");
		return resultMap;
	}

	private HashMap<String, Object> averageCapitalCombination(double accInvest, double accYearRate, int accTotalmonth,
			double busInvest, double busYearRate, int busTotalmonth) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> yearsList = new ArrayList<>();
		List<List<Integer>> listValues = new ArrayList<>();
		Map<String, Object> yearsMap = new HashMap<>();

		// 每月偿还本金+利息
		Map<Integer, Double> princiMap = AverageCapitalUtils.getCombinationPerMonthPrincipalInterest(accInvest,
				accYearRate, accTotalmonth, busInvest, busYearRate, busTotalmonth);
		// 每月偿还利息
		Map<Integer, Double> interestMap = AverageCapitalUtils.getCombinationPerMonthInterest(accInvest, accYearRate,
				accTotalmonth, busInvest, busYearRate, busTotalmonth);
		// 每月偿还本金
		Map<Integer, Double> everyPriceMap = AverageCapitalUtils.getCombinationPerMonthPrincipal(accInvest,
				accTotalmonth, busInvest, busTotalmonth);
		// 总利息
		double principalInterestCount = AverageCapitalUtils.getCombinationInterestCount(accInvest, accYearRate,
				accTotalmonth, busInvest, busYearRate, busTotalmonth);
		// 每月应还金额
		Double alreadyPrice = 0.0;
		int every = 0;
		int maxMonth = Math.max(accTotalmonth, busTotalmonth);
		for (int i = 1; i <= maxMonth; i++) {

			List<Integer> listValue = new ArrayList<>();
			listValue.add(i);
			every += princiMap.get(i).intValue();
			listValue.add(princiMap.get(i).intValue());
			listValue.add(everyPriceMap.get(i).intValue());
			listValue.add((new BigDecimal(interestMap.get(i)).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue());
			alreadyPrice = alreadyPrice + (princiMap.get(i).intValue());
			int intPrice = alreadyPrice.intValue();

			if (i == maxMonth) {
				listValue.add(0);
			} else {
				listValue.add((new BigDecimal(principalInterestCount + accInvest + busInvest).setScale(0,
						BigDecimal.ROUND_HALF_UP)).intValue() - intPrice);
			}
			listValues.add(listValue);
			if (i % 12 == 0) {
				yearsMap.put("year", "第" + i / 12 + "年");
				yearsMap.put("record", listValues);
				yearsList.add(yearsMap);
				listValues = new ArrayList<>();
				yearsMap = new HashMap<>();
			}
		}
		resultMap.put("detail", yearsList);
		resultMap.put("totalInterest", principalInterestCount);
		resultMap.put("everyPrice", (int) every / maxMonth + "元/月");
		return resultMap;
	}

	private HashMap<String, Object> averageCapital(double invest, int totalMonth, double yearRate) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> yearsList = new ArrayList<>();
		List<List<Integer>> listValues = new ArrayList<>();
		Map<String, Object> yearsMap = new HashMap<>();

		// 每月偿还本金+利息
		Map<Integer, Double> princiMap = AverageCapitalUtils.getPerMonthPrincipalInterest(invest, yearRate, totalMonth);
		// 每月偿还利息
		Map<Integer, Double> interestMap = AverageCapitalUtils.getPerMonthInterest(invest, yearRate, totalMonth);
		// 每月偿还本金
		Double everyPrice = AverageCapitalUtils.getPerMonthPrincipal(invest, totalMonth);
		// 总利息
		double principalInterestCount = AverageCapitalUtils.getInterestCount(invest, yearRate, totalMonth);
		// 每月应还金额
		Double alreadyPrice = 0.0;
		int every = 0;
		for (int i = 1; i <= totalMonth; i++) {

			List<Integer> listValue = new ArrayList<>();
			listValue.add(i);
			every += princiMap.get(i).intValue();
			listValue.add(princiMap.get(i).intValue());
			listValue.add(everyPrice.intValue());
			listValue.add((new BigDecimal(interestMap.get(i)).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue());
			alreadyPrice = alreadyPrice + (princiMap.get(i).intValue());
			int intPrice = alreadyPrice.intValue();
			listValue.add(
					(new BigDecimal(principalInterestCount + invest).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue()
							- intPrice);
			listValues.add(listValue);
			if (i % 12 == 0) {
				yearsMap.put("year", "第" + i / 12 + "年");
				yearsMap.put("record", listValues);
				yearsList.add(yearsMap);
				listValues = new ArrayList<>();
				yearsMap = new HashMap<>();
			}
		}
		resultMap.put("detail", yearsList);
		resultMap.put("totalInterest", principalInterestCount);
		resultMap.put("everyPrice", (int) every / totalMonth + "元/月");
		return resultMap;
	}

	@Override
	public Result getLoanRate(Integer type) {

		Result result = new Result();
		MortgageExample example = new MortgageExample();
		MortgageExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0);
		if (type != null) {
			andDeleteFlagEqualTo.andLoanTypeEqualTo(type);
		}
		example.setOrderByClause("dataStatus desc,loanDetal desc");
		List<Mortgage> selectByExample = mortgageMapper.selectByExample(example);
		result.setStatus(Result.SUCCESS);
		result.setData(selectByExample);
		result.setTotalSize(selectByExample.size());
		return result;
	}

	@Override
	public Result getBuildingOldDetail(String buildingOldId) {
		Result result = new Result();
		if (!StringUtils.isEmpty(buildingOldId)) {
			BuildingOld building = buildingOldMapper.selectByPrimaryKey(buildingOldId);
			if (building == null) {
				return result;
			}
			List<HashMap<String, Object>> params = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				HashMap<String, Object> param = new HashMap<>();
				switch (i) {
				case 0:
					param.put("param1", "售价：" + (building.getPrice() == null ? "" : building.getPrice()));
					break;
				case 1:
					param.put("param1", "面积：" + (building.getArea() == null ? "" : building.getArea() + "平方米"));
					param.put("param2", "装修情况：" + (building.getDecorateSituation() == null ? ""
							: getBaseInfoValue("decorateSituation" + building.getDecorateSituation())));
					break;
				case 2:
				
					param.put("param1", "朝向：" + (building.getOrientation() == null ? "" : getBaseInfoValue("orientation"+building.getOrientation()) ));
					param.put("param2", "年代：" + (building.getYears() == null ? "" : building.getYears() + "年"));
					break;
				case 3:
					param.put("param1", "所在楼层：" + (building.getFloor() == null ? "" : building.getFloor() + "层"));
					param.put("param2", "总楼层：" + (building.getAllFloor() == null ? "" : building.getAllFloor() + "层"));
					break;
				case 4:
					param.put("param1",
							"是否临街：" + ((building.getIsStreet() != null && building.getIsStreet() == 1) ? "是" : "否"));
					param.put("param2",
							"是否有车库：" + ((building.getIsGarage() != null && building.getIsGarage() == 1) ? "是" : "否"));
					break;
				}

				params.add(param);
			}

			result.setData(params);
			result.setStatus(Result.SUCCESS);
		}

		return result;
	}

	@Override
	public Result calculateCombinationLoan(double accInvest, double accYearRate, int accTotalmonth, double busInvest,
			double busYearRate, int busTotalmonth, int type) {
		Result result = new Result();

		result.setData(type == 0
				? (averageCapitalPlusInterestCombination(accInvest, accYearRate, accTotalmonth, busInvest, busYearRate,
						busTotalmonth))
				: (averageCapitalCombination(accInvest, accYearRate, accTotalmonth, busInvest, busYearRate,
						busTotalmonth)));
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result getUnReportClient(String agentId, String buildId) {
		Result result = new Result();
		if (StringUtils.isEmpty(agentId) || StringUtils.isEmpty(buildId)) {
			return result;
		} else {
			result.setData(clientMapper.getUnReportClient(agentId, buildId));
			result.setStatus(Result.SUCCESS);
		}
		return result;
	}

}
