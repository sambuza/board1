import React from "react";
import HeroMessage01 from "./HeroMessage01";
import HeroImage01 from "./HeroImage01";
import HeroImage02 from "./HeroImage02";
import HeroImage03 from "./HeroImage03";
import HeroImage04 from "./HeroImage04";

function Hero() {
  return (
    <>
      <div className='hero_Main_Image'>
        <img src='/imgs/1400600_1.jpg' alt='예시 이미지' />
        <HeroMessage01></HeroMessage01>
        <div className='heroimages'>
          <HeroImage01 />
          <HeroImage02 />
          <HeroImage03 />
          <HeroImage04 />
        </div>
      </div>
    </>
  );
}

export default Hero;
