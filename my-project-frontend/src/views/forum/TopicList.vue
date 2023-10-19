<script setup>

import LightCard from "@/components/LightCard.vue";
import {Calendar, CollectionTag} from "@element-plus/icons-vue";
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
        </light-card>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>