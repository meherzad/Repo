function Slider(container, nav){
    this.container=container;
    this.nav=nav;
    this.imgs=this.container.find('img');
    this.imgLen=this.imgs.length;
	
    this.imgWidth=this.imgs[0].width;
    this.current=0;
	
}

Slider.prototype.transition=function(){
    this.container.animate({
        'margin-left': -(this.current*this.imgWidth)
    });
};

Slider.prototype.setCd=function(direction){
    var pos=this.current;
    if (direction==='next')
        pos+=1;
    else
        pos-=1;
    //pos+=(~~(direction==='next')|| -1); //Checking whether next or previous key is pressed. Same as using if else
    this.current=(pos<0)?this.imgLen-1:pos%this.imgLen;	
    return pos;
};