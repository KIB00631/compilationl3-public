ls | grep '\.sc' | xargs rm
ls | grep '\.l' | xargs -I{} java -cp ../../out/production/compilationl3-public Compiler {}
