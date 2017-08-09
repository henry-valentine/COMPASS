#version 330

/**
 * Fragment Shader
 * Takes in vertex data then interpolates calculations over every pixel on the face
 */
 
in vec2 texCoord0;
in vec3 normal0;
in vec3 worldPos0;

out vec4 fragColor;

struct BaseLight {
	vec3 color;
	float intensity;
};

struct DirectionalLight {
	BaseLight base;
	vec3 direction;
};

uniform vec3 eyePos; 				//Telescope position
uniform vec3 baseColor;				//Light Color
uniform vec3 ambientLight;			//Ambient light color
uniform sampler2D sampler;

uniform float specularIntensity;	//Reflection intensity 
uniform float specularPower;		//how wide reflection is

uniform DirectionalLight directionalLight;

/*
 * returns the color modification for each pixel
 */
vec4 calcLight(BaseLight base, vec3 direction, vec3 normal) {
	float diffuseFactor = dot(normal, -direction);
	
	vec4 diffuseColor = vec4(0, 0, 0, 0);
	vec4 specularColor = vec4(0, 0, 0, 0);
	
	
	if(diffuseFactor > 0) {
	
		diffuseColor = vec4(base.color, 1.0) * base.intensity * diffuseFactor;
		
		vec3 directionToEye = normalize(eyePos - worldPos0);
		vec3 reflectDirection = normalize(reflect(direction, normal));	//GLSL built in reflect fuction.  
																		//returns reflection direction given a light direction and surface normal
		float specularFactor = dot(directionToEye, reflectDirection);	//how much of the light is reflected directly at the eye
		specularFactor = pow(specularFactor, specularPower);			//Increases the value based on the specularPower
		
		if(specularFactor > 0) {
			specularColor = vec4(base.color, 1.0) * specularIntensity * specularFactor;		//set specular factor if there is one
		}
	}
	return diffuseColor + specularColor;
}//end calcLight

/*
 * Wrapper function. calculates the light color of a pixel given its normal and the direction
 * of the light that hits it
 */
vec4 calcDirectionalLight(DirectionalLight directionalLight, vec3 normal) {
	return calcLight(directionalLight.base, -directionalLight.direction, normal);
}

void main() 
{	
	vec4 totalLight = vec4(ambientLight, 1);				//Sum of all the lighting components
	vec4 color = vec4(baseColor, 1);						//pixel color
	
	vec4 textureColor = texture2D(sampler, texCoord0.xy);	//color of the mapped location on the texture for this pixel
	
	if(textureColor != vec4(0, 0, 0, 0)) 
		color *= textureColor;	//Color is set to the color of the texture pixel that its associated with
	
    vec3 normal = normalize(normal0);
	
	totalLight += calcDirectionalLight(directionalLight, normal); //Summing all the light components
	
	fragColor = color * totalLight;	//setting the pixel color once and for all! MUAHAHAHAHAHA
}