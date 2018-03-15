<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
	<style type="text/css">

        *{
            margin: 0;padding: 0;
        }

        html,body {
            width: 100%;
            height: 100%;
        }

        body {
            font-family: pingfang sc light;
        }


        .center{
            text-align: center;
            width: 100%;
        }




        .center {
            text-align: center;
            width: 100%;
        }


        .com_report_table{width: 100%;}
        .com_report_table table{border: none;border-spacing:10px;border-collapse: separate;}
        .com_report_table thead,.com_report_table tbody{border: none;}
        .com_report_table thead td,.com_report_table thead th{background-color: #c2c2c2;line-height: 36px;}
        .com_report_table td{padding: 0;line-height: 36px;white-space: normal;border: 1px solid #c2c2c2;text-align: center;color: #333;word-break: break-all}
        .com_report_table tr>td:last-of-type{border-right: 1px solid #c2c2c2;}
        .com_report_table tbody td{padding:0 10px;}


</style> 
	</head>
	
<body>
		<div class="center">
				区域评估报告
		</div>
		
		<div class="center">
				区域信息
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<td style="width: 320px">当前评估区域:</td>
					<td style="width: 320px">${area!''}</td>
				</tr>
				<tr>
					<td >区域企业总量:</td>
					<td>${count!''}</td>
				</tr>
				<tr>
					<td >金融涉诉总量:</td>
					<td>${risk.courtCount!''}</td>
				</tr>
				<tr>
					<td >投放建议:</td>
					<td>
						<#if region.score lt 20>
							禁入
						<#elseif region.score lt 30>
							谨慎进入
						<#elseif region.score lt 50>
							适度投放
						<#else>
							优先投放
						</#if>
					</td>
				</tr>
			</table>
		</div>

		<div class="center">
				区域概况
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">

				<tr>
					<td >发展水平:</td>
					<td>${region.development.score!''}</td>
				</tr>
				<tr>
					<td >稳定程度:</td>
					<td>${region.stable.score!''}</td>
				</tr>
				<tr>
					<td >金融供给:</td>
					<td>${region.financialSupply.score!''}</td>
				</tr>
				<tr>
					<td >风险文化:</td>
					<td>${region.riskCulture.score!''}</td>
				</tr>
				<tr>
					<td >区域得分:</td>
					<td>${region.score!''}</td>
				</tr>
			</table>
		</div>
		

		<div class="center">
				发展水平
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:125px">GDP总量(万元)</th>
					<th style="width:125px">人均GDP(万元)</th>
					<th style="width:125px">税收总量(万元)</th>
					<th style="width:140px">人均贷款偏离度</th>
					<th style="width:125px">财政支出(万元)</th>
				</tr>
				
				<tr>
					<td>${region.development.gDPtotal!''}</td>
					<td>${region.development.gDPAvg!''}</td>
					<td>${region.development.taxTotal!''}</td>
					<td>${region.development.avgLoanDeviation*100!''}%</td>
					<td>${region.development.expenditure!''}</td>
				</tr>
			</table>
		</div>


		<div class="center">
				稳定程度
		</div>


		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:213px">GDP增长率</th>
					<th style="width:213px">财政收入(万元)</th>
					<th style="width:213px">本地新注册法人增长水平</th>
					
				</tr>
				
				<tr>
					<td>${region.stable.gdpGrowthRate*100!''}%</td>
					<td>${region.stable.expenditureGrowthRate!''}</td>
					<td>${region.stable.companyGrowthCount*100!''}%</td>
				
				</tr>
			</table>
		</div>

		<div class="center">
				注册资本占比统计
		</div>

		
		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width: 55px">50万以下</th>
					<th style="width: 65px">50-100万</th>
					<th style="width: 65px">101-200万</th>
					
					<th style="width: 65px">201-300万</th>
					<th style="width: 65px">301-500万</th>
					<th style="width: 65px">501-600万</th>
					
					<th style="width: 65px">601-800万</th>
					<th style="width: 65px">801-1000万</th>
					<th style="width: 65px">1001-2000万</th>
					
					<th style="width: 65px">2000万以上</th>
				</tr>
				
				<tr>
					<td>${register.registerCapital.lessThan500Thousand!''}</td>
					<td>${register.registerCapital.between500And1000Thousand}</td>
					<td>${register.registerCapital.between1And2Millon!''}</td>
				
					<td>${register.registerCapital.between2And3Millon!''}</td>
					<td>${register.registerCapital.between3And5Millon}</td>
					<td>${register.registerCapital.between5And6Millon!''}</td>
					
					<td>${register.registerCapital.between6And8Millon!''}</td>
					<td>${register.registerCapital.between8And10Millon!''}</td>
					<td>${register.registerCapital.between10And20Millon!''}</td>
					
					<td>${register.registerCapital.more20Millon!''}</td>
				</tr>
			</table>
		</div>
		

		<div class="center">
				注册时间占比统计
		</div>

		
		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:100px">1年以下</th>
					<th style="width:100px">1-2年</th>
					<th style="width:100px">2-4年</th>
					
					<th style="width:100px">4-6年</th>
					<th style="width:100px">6-8年</th>
					<th style="width:100px">8-10年</th>
					<th style="width:100px">10年以上</th>
				</tr>
				
				<tr>
					<td>${register.registerTime.lessThanOneYear!''}</td>
					<td>${register.registerTime.between1And2Year!''}</td>
					<td>${register.registerTime.between3And4Year!''}</td>
				
					<td>${register.registerTime.between5And6Year}</td>
					<td>${register.registerTime.between7And8Year!''}</td>
					<td>${register.registerTime.between9And10Year!''}</td>
					
					<td>${register.registerTime.more10Year!''}</td>
					
				</tr>
			</table>
		</div>

		<div class="center">
				近十年企业增长消亡数
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:58px"></th>

					<#list growthAndDie.growthCurve as item>
					    <th style="width:58px">${item.year!''}</th>
					</#list>


				</tr>
				
				<tr>
					<td>增长率</td>
					<#list growthAndDie.growthCurve as item>
					    <td>

							<#if item.rate??>
								${item.rate}
							</#if>
						</td>
					</#list>
				</tr>

                <tr>
                    <td>消亡率</td>
                    <#list growthAndDie.dieCurve as item>
					    <td>
							<#if item.rate??>
								${item.rate}
							</#if>
						</td>
					</#list>
                </tr>


			</table>
		</div>

		<div class="center">
				金融供给
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:213px">企业户均贷款额度平均偏离度</th>
					<th style="width:213px">民间金融活跃度</th>
					<th style="width:213px">贷款GDP贡献率</th>
				</tr>
				
				<tr>
					<td>${region.financialSupply.avgLoanDeviation!''}</td>
					<td>${region.financialSupply.peopleActivity!''}</td>
					<td>${region.financialSupply.gdpLoanRate!''}</td>
				</tr>
				
			</table>
			
		</div>

		<div class="center">
				近三年区域涉诉及违法数
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:58px"></th>
					<#list illegal.breakFaith as item>
						<th style="width:58px">${item.year!''}</th>
					</#list>

				</tr>
				<tr>
					<td>失信记录</td>
					<#list illegal.breakFaith as item>
						<td>${item.value!''}</td>
					</#list>

				</tr>
				<tr>
					<td>裁判文书</td>
					<#list illegal.court as item>
						<td>${item.value!''}</td>
					</#list>
				</tr>

				<tr>
					<td>法院公告</td>
					<#list illegal.courtPub as item>
						<td>${item.value!''}</td>
					</#list>
				</tr>

                <tr>
                    <td>被执行</td>
                    <#list illegal.executed as item>
						<td>${item.value!''}</td>
					</#list>
                </tr>

			</table>
		</div>
		

		<div class="center">
				风险文化
		</div>
		<BR/><BR/>
		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:213px">企业户均涉金融债数量</th>
					<th style="width:213px">贷存比</th>
					<th style="width:213px">金融犯罪指数</th>
				</tr>
				<tr>
					<td>${region.riskCulture.avgCompanyLoan!''}</td>
					<td>${region.riskCulture.loanRatio!''}</td>
					<td>${region.riskCulture.crimeIndex!''}</td>
				</tr>
			</table>
		</div>

		<div class="center">
				限入行业
		</div>

		<div class="com_report_table">
			<table width="100%" cellspacing="10">
				<tr>
					<th style="width:320px">限入行业占比:</th>
					<th style="width:320px">${region.limit.index!''}</th>
				</tr>
			</table>
		</div>
</body>
	
</html>
