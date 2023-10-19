<script setup>

import LightCard from "@/components/LightCard.vue";
import {Calendar, CollectionTag} from "@element-plus/icons-vue";
import Weather from "@/components/Weather.vue";
import {computed} from "vue";

const today=computed(()=>{
  const date=new Date()
  return `${date.getFullYear()} 年 ${date.getMonth()} 月 ${date.getDay()} 日`
})
</script>

<template>
  <div style="display: flex;margin: 20px auto;gap: 20px;max-width: 900px">
    <div style="flex: 1">
      <light-card style="height: 2000px"/>
    </div>
    <div style="width: 280px">
      <div style="position: sticky;top: 20px">
        <light-card>
          <div style="font-weight: bold">
            <el-icon><CollectionTag/></el-icon>
            论坛公告
          </div>
          <el-divider style="margin: 10px 0"/>
          <div style="font-size: 14px;margin: 10px;color: grey">
            你说的对，但是元神是一款开放世界游戏！
          </div>
        </light-card>
<!--天气预报接口API-->
        <light-card style="margin-top: 10px">
          <div style="font-weight: bold">
            <el-icon><Calendar/></el-icon>
            天气信息
          </div>
          <el-divider style="margin: 10px 0"/>
          <weather/>
        </light-card>
        <light-card style="margin-top: 10px">
          <div class="info-text">
            <div>当前日期</div>
            <div>{{today}}</div>
          </div>
          <div>
            <div>当前IP地址</div>
            <div>127.0.0.1</div>
          </div>
        </light-card>
      </div>
    </div>
  </div>
</template>

<style scoped>
.info-text{
  display: flex;
  justify-content: space-between;
  color: grey;
  font-size: 14px;
}
</style>