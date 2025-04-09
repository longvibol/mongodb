db.createCollection('posts',
    {
    validator:{
        $jsonSchema:{
            bsonType:'object',
            required:['title','text','creator','comments'],
            properties:{
                title:{
                    bsonType:'string',
                    description:'Title of the post'
                },
                text:{
                    bsonType:'string',
                    description:'Text of the post'
                },
                creator:{
                    bsonType:'objectId',
                    description:'Creator of the post'
                },
                comments:{
                    bsonType:'array',
                    items:{
                        bsonType:'object',
                        required:['text','author'],
                        properties:{
                            text:{
                                bsonType:'string',
                                description:'Text of the post'
                            },
                            author:{
                                bsonType:'objectId',
                                description:'Must be a valid ObjectId'
                            }
                        }
                    }
                }

            }
        }
    }
})      

db.runCommand({
    collMod:'posts',
    validator:{
        $jsonSchema:{
            bsonType:'object',
            required:['title','text','creator','comments'],
            properties:{
                title:{
                    bsonType:'string',
                    description:'Title of the post'
                },
                text:{
                    bsonType:'string',
                    description:'Text of the post'
                },
                creator:{
                    bsonType:'objectId',
                    description:'Creator of the post'
                },
                comments:{
                    bsonType:'array',
                    items:{
                        bsonType:'object',
                        required:['text','author'],
                        properties:{
                            text:{
                                bsonType:'string',
                                description:'Text of the post'
                            },
                            author:{
                                bsonType:'objectId',
                                description:'Must be a valid ObjectId'
                            }
                        }
                    }
                }

            }
        },
    validationAction:'error',
    }
})


